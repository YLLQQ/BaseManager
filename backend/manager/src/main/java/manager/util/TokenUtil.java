package manager.util;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import manager.response.ManagerCodeEnum;
import org.springframework.util.StringUtils;
import self.unity.response.exception.UnifiedInteractiveException;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author yangguoqing
 */
public class TokenUtil {

	private static final String JWT_SECRET = "e10adc3949ba59abbe56e057f20f883e";

	private static final Long JWT_EXPIRE_DATE = 1L;

	private static Algorithm jwtAlgorithm = Algorithm.HMAC256(JWT_SECRET);

	private static JWTCreator.Builder jwtBuilder = JWT.create();

	private static Verification jwtVerification = JWT.require(jwtAlgorithm);

	public static void verifyToken(String token) {

		if (StringUtils.isEmpty(token)) {
			throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_GET_FAIL);
		}

		try {
			DecodedJWT decodedJWT = JWT.decode(token);
			String issuer = decodedJWT.getIssuer();

			JWTVerifier verifier = jwtVerification.withIssuer(issuer).build();

			verifier.verify(token);
		} catch (JWTVerificationException exception) {
			if (exception instanceof JWTDecodeException) {
				throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_DECODED_FAIL);
			}

			if (exception instanceof SignatureVerificationException) {
				throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_SIGNATURE_VERIFICATION_FAIL);
			}

			if (exception instanceof TokenExpiredException) {
				throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_EXPIRED);
			}

			exception.printStackTrace();

			throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_VERIFY_NOT_PASS);
		}
	}

	public static <T> String signWithJwt(T t) {
		try {
			return jwtBuilder.withIssuer(JSONObject.toJSONString(t))
					.withClaim("startTime", new java.util.Date())
					.withExpiresAt(Date.from(LocalDateTime.now().plusDays(JWT_EXPIRE_DATE).atZone(ZoneId.systemDefault()).toInstant()))
					.sign(jwtAlgorithm);
		} catch (JWTCreationException exception) {
			exception.printStackTrace();

			throw new UnifiedInteractiveException(ManagerCodeEnum.TOKEN_CREATE_FAIL);
		}
	}
}
