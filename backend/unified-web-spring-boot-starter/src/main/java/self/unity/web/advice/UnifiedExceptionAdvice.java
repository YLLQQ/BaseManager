package self.unity.web.advice;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import self.unity.response.UnifiedResponse;
import self.unity.response.enums.UnifiedResponseCodeEnum;
import self.unity.response.exception.UnifiedInteractiveException;

import javax.management.ReflectionException;
import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

/**
 * @author yangguoqing
 */
@Slf4j
@RestControllerAdvice
public class UnifiedExceptionAdvice {

	@ExceptionHandler(value = BadSqlGrammarException.class)
	public UnifiedResponse badSqlGrammarException(BadSqlGrammarException e) {
		log.error("happen badSqlGrammarException, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SQL_SYNTAX_ERROR);
	}

	@ExceptionHandler(value = MyBatisSystemException.class)
	public UnifiedResponse myBatisSystemException(MyBatisSystemException e) {
		log.error("happen myBatisSystemException, message is [{}]", e.toString());

		if (e.getCause() instanceof ReflectionException) {
			return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.MYBATIS_REFLECTION_ERROR);
		}

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.MYBATIS_REFLECTION);
	}

	@ExceptionHandler(value = DuplicateKeyException.class)
	public UnifiedResponse duplicateKeyExceptionHandler(DuplicateKeyException e) {
		log.error("happen duplicateKeyExceptionHandler, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_UNIQUE_KEY_EXISTS);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public UnifiedResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		log.error("happen methodArgumentNotValidExceptionHandler, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_ATTRIBUTE_MUST_HAVE_VALUE);
	}

	@ExceptionHandler(value = NoSuchElementException.class)
	public UnifiedResponse noSuchElementExceptionHandler(NoSuchElementException e) {
		log.error("happen noSuchElementExceptionHandler, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_GET_VALUE_IS_NULL);
	}

	@ExceptionHandler(value = HttpClientErrorException.class)
	public UnifiedResponse httpClientErrorExceptionHandler(HttpClientErrorException e) {
		log.error("happen httpClientErrorExceptionHandler, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.HTTP_CLIENT_NOT_WORK);
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public UnifiedResponse httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		log.error("happen httpMessageNotReadableExceptionHandler, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.HTTP_MESSAGE_NOT_READABLE);
	}

	@ExceptionHandler(value = UnifiedInteractiveException.class)
	public UnifiedResponse interactiveWithAppExceptionHandler(
			HttpServletRequest request,
			UnifiedInteractiveException e
	) {
		log.error("visit [{}] happen interactiveWithAppExceptionHandler, message is [{}]", request.getRequestURI(),
				e.toString());

		return UnifiedResponse.getInstance(e.getUnifiedResponseInter());
	}

	@ExceptionHandler(value = Exception.class)
	public UnifiedResponse exceptionHandler(Exception e) {
		log.error("happen unknown exception, message is [{}]", e.toString());

		return UnifiedResponse.getInstance(UnifiedResponseCodeEnum.SYSTEM_UNKNOWN_EXCEPTION);
	}
}
