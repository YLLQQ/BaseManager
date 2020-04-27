package manager.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import manager.common.annotation.IgnoreToken;
import manager.util.TokenUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import self.unity.response.enums.UnifiedResponseCodeEnum;
import self.unity.response.exception.UnifiedInteractiveException;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@Aspect
@Configuration
public class TokenAspect {

	@Pointcut(
			"@annotation(org.springframework.web.bind.annotation.GetMapping)|| " +
					"@annotation(org.springframework.web.bind.annotation.PostMapping)|| " +
					"@annotation(org.springframework.web.bind.annotation.PutMapping)|| " +
					"@annotation(org.springframework.web.bind.annotation.DeleteMapping)" +
					")"
	)
	public void point() {
	}

	@Around("point()")
	public Object handle(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		Signature signature = proceedingJoinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		IgnoreToken ignoreToken = method.getAnnotation(IgnoreToken.class);

		if (null != ignoreToken && ignoreToken.value()) {
			return proceedingJoinPoint.proceed();
		}

		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();

		String authorization = request.getHeader("Authorization");

		if (log.isDebugEnabled()) {
			log.debug("deal with request aspect, token is [{}]", authorization);
		}

		if (StringUtils.isEmpty(authorization)) {
			throw new UnifiedInteractiveException(UnifiedResponseCodeEnum.TOKEN_GET_FAIL);
		}

		TokenUtil.verifyToken(authorization);

		DecodedJWT decode = JWT.decode(authorization);

		JSONObject issuer = JSONObject.parseObject(decode.getIssuer());

		if (log.isDebugEnabled()) {
			log.debug("deal with request aspect, issuer is [{}]", issuer);
		}

		issuer.forEach((key, value) -> requestAttributes.setAttribute(key, value.toString(), 0));

		if (log.isDebugEnabled()) {
			log.debug("deal with request aspect, servlet request attributes is [{}]",
					requestAttributes.getAttributeNames(0));
		}

		RequestContextHolder.resetRequestAttributes();

		RequestContextHolder.setRequestAttributes(requestAttributes);

		return proceedingJoinPoint.proceed();
	}

}
