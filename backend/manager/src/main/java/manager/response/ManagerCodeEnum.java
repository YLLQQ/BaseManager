package manager.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import self.unity.response.inter.UnifiedResponseInter;

/**
 * @author yangguoqing
 */
@Getter
@ToString
@AllArgsConstructor
public enum ManagerCodeEnum implements UnifiedResponseInter {

	MANAGER_INFO_NOT_EXISTS_WITH_PASSWORD(1000, "管理员账户密码错误"),

	MANAGER_INFO_NOT_EXISTS(1000, "管理员信息不存在"),
	MANAGER_INFO_LIST_MISSING(1001, "管理员信息列表不存在"),

	ROLE_INFO_NOT_EXISTS(1100, "角色信息不存在"),
	ROLE_INFO_LIST_MISSING(1101, "角色信息列表丢失"),

	MENU_INFO_NOT_EXISTS(1200, "菜单信息不存在"),
	MENU_INFO_LIST_MISSING(1201, "菜单信息列表不存在"),

	RELATION_MENU_ROLE_NOT_EXISTS(2000, "角色下无可用菜单"),

	TOKEN_CREATE_FAIL(9000, "token创建失败"),
	TOKEN_VERIFY_NOT_PASS(9001, "token校验未通过"),
	TOKEN_DECODED_FAIL(9002, "token解码失败"),
	TOKEN_SIGNATURE_VERIFICATION_FAIL(9003, "token验签未通过"),
	TOKEN_EXPIRED(9004, "token过期"),
	TOKEN_GET_FAIL(9005, "请求未携带有效token");

	/**
	 * 响应码
	 */
	private int code;

	/**
	 * 描述信息
	 */
	private String message;
}
