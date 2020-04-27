package self.unity.web.advice;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import self.unity.response.UnifiedResponse;
import self.unity.response.enums.UnifiedResponseCodeEnum;
import self.unity.response.inter.UnifiedResponseInter;

import java.util.Collection;

/**
 * @author yangguoqing
 */
@Slf4j
@ControllerAdvice
public class UnifiedResponseBodyAdvice implements ResponseBodyAdvice {
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		RestController restController = returnType.getDeclaringClass().getAnnotation(RestController.class);

		return restController != null;
	}

	@Override
	public Object beforeBodyWrite(
			Object body,
			MethodParameter returnType,
			MediaType selectedContentType,
			Class selectedConverterType,
			ServerHttpRequest request,
			ServerHttpResponse response
	) {
		if (log.isDebugEnabled()) {
			log.debug("current body is [{}]", body);
		}

		if (body instanceof UnifiedResponseInter) {
			return body;
		}

		if (body instanceof String) {
			UnifiedResponse unifiedResponse = UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SUCCESS, body);

			return JSON.toJSONString(unifiedResponse);
		}

		if (body instanceof Collection) {
			if (((Collection) body).isEmpty()) {
				return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_GET_VALUE_IS_NULL);
			}
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SUCCESS, body);
	}
}
