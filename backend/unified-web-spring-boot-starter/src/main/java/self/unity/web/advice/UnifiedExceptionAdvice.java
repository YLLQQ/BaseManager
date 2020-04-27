package self.unity.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import self.unity.response.UnifiedResponse;
import self.unity.response.enums.UnifiedResponseCodeEnum;
import self.unity.response.exception.UnifiedInteractiveException;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

/**
 * @author yangguoqing
 */
@Slf4j
@RestControllerAdvice
public class UnifiedExceptionAdvice {

	@ExceptionHandler(value = DuplicateKeyException.class)
	public UnifiedResponse duplicateKeyExceptionHandler(DuplicateKeyException e) {
		if (log.isDebugEnabled()) {
			log.debug("current duplicate key exception detail", e);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_UNIQUE_KEY_EXISTS);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public UnifiedResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		if (log.isDebugEnabled()) {
			log.debug("current method argument not valid exception detail", e);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_ATTRIBUTE_MUST_HAVE_VALUE);
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public UnifiedResponse noSuchElementExceptionHandler(NoSuchElementException e) {
		if (log.isDebugEnabled()) {
			log.debug("current no such element exception detail", e);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_GET_VALUE_IS_NULL);
	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	public UnifiedResponse httpClientErrorExceptionHandler(HttpClientErrorException e) {
		if (log.isDebugEnabled()) {
			log.debug("current http client error exception detail", e);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.HTTP_CLIENT_NOT_WORK);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public UnifiedResponse httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		if (log.isDebugEnabled()) {
			log.debug("current http message not readable exception detail", e);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.HTTP_MESSAGE_NOT_READABLE);
	}

	@ExceptionHandler(value = UnifiedInteractiveException.class)
	public UnifiedResponse interactiveWithAppExceptionHandler(
			HttpServletRequest request,
			UnifiedInteractiveException e
	) {
		if (log.isDebugEnabled()) {
			log.debug("current interactive exception detail", e);
		}

		log.error("visit [{}] has exception, message is [{}]", request.getRequestURI(), e.toString());

		return UnifiedResponse.getInstance(e.getUnifiedResponseInter());
	}

	@ExceptionHandler(value = Exception.class)
	public UnifiedResponse exceptionHandler(Exception e) {
		log.error("[ happen unknown exception ]", e);

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_UNKNOWN_EXCEPTION);
	}
}
