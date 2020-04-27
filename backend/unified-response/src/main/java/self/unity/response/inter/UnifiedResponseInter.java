package self.unity.response.inter;

/**
 * @author yangguoqing
 */
public interface UnifiedResponseInter {

	/**
	 * 获取响应码
	 *
	 * @return
	 */
	int getCode();

	/**
	 * 获取描述信息
	 *
	 * @return
	 */
	String getMessage();

}
