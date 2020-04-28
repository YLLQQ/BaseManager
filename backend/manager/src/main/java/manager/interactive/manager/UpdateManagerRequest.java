package manager.interactive.manager;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Data
public class UpdateManagerRequest {

	@NotNull
	private Integer id;

	@NotBlank
	private String password;

	@NotNull
	private Integer roleId;

	@NotBlank
	private String loginName;

}
