package manager.interactive.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author yangguoqing
 */
@Data
public class AddRoleRequest {

	@NotEmpty
	private String roleName;
}
