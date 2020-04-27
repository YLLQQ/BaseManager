package self.unity.response.exception;

import lombok.Getter;
import self.unity.response.inter.UnifiedResponseInter;

/**
 * @author yangguoqing
 */
@Getter
public class UnifiedInteractiveException extends RuntimeException {

	private UnifiedResponseInter unifiedResponseInter;

	private UnifiedInteractiveException(String message) {
		super(message);
	}

	public UnifiedInteractiveException(UnifiedResponseInter unifiedResponseInter) {
		this(unifiedResponseInter.toString());

		this.unifiedResponseInter = unifiedResponseInter;
	}
}
