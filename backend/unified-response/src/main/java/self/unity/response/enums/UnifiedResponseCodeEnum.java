package self.unity.response.enums;

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
public enum UnifiedResponseCodeEnum implements UnifiedResponseInter {

	SUCCESS(200, "响应成功"),
	SUCCESS_RETURN_NULL(201, "响应成功，无法通过请求获取有效响应"),

	HTTP_CLIENT_NOT_WORK(9100, "请求客户端异常"),
	HTTP_MESSAGE_NOT_READABLE(9101, "请求体读入失败"),

	SQL_SYNTAX_ERROR(9799,"SQL语法错误"),

	MYBATIS_REFLECTION_ERROR(9898, "入库映射字段错误"),
	MYBATIS_REFLECTION(9899, "Mybatis处理异常"),

	SYSTEM_UNIQUE_KEY_EXISTS(9996, "唯一键已存在"),
	SYSTEM_ATTRIBUTE_MUST_HAVE_VALUE(9997, "强制标识字段未设置"),
	SYSTEM_GET_VALUE_IS_NULL(9998, "该次请求获取数据为空"),
	SYSTEM_UNKNOWN_EXCEPTION(9999, "暂未捕捉异常");

	/**
	 * 响应码
	 */
	private int code;

	/**
	 * 描述信息
	 */
	private String message;
}
