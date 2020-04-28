package manager.interactive.manager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Data
public class AddManagerRequest {

	@NotBlank
	private String loginName;

	@NotBlank
	private String password;

	@NotNull
	private Integer roleId;
}
