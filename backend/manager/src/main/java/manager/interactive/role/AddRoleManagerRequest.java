package manager.interactive.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yangguoqing
 */
@Data
public class AddRoleManagerRequest {

	@NotEmpty
	private String managerRoleName;
}
