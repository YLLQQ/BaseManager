package self.unity.response;

import lombok.Data;
import self.unity.response.inter.UnifiedResponseInter;

/**
 * @author yangguoqing
 */
@Data
public class UnifiedResponse implements UnifiedResponseInter {

	/**
	 * 响应码
	 */
	private int code;

	/**
	 * 描述信息
	 */
	private String message;

	/**
	 * 接口响应信息
	 */
	private Object result;

	private UnifiedResponse(int code, String message, Object result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public static UnifiedResponse getInstance(UnifiedResponseInter baseResponseInter) {
		return new UnifiedResponse(
				baseResponseInter.getCode(),
				baseResponseInter.getMessage(),
				null
		);
	}

	public static UnifiedResponse getInstance(UnifiedResponseInter baseResponseInter, Object result) {
		return new UnifiedResponse(
				baseResponseInter.getCode(),
				baseResponseInter.getMessage(),
				result
		);
	}

	public static UnifiedResponse getInstanceWithMessage(UnifiedResponseInter baseResponseInter, String message) {
		return new UnifiedResponse(
				baseResponseInter.getCode(),
				message,
				null
		);
	}
}
