package manager.interactive.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Data
public class UpdateRoleRequest {

	@NotNull
	private Integer id;

	@NotEmpty
	private String roleName;
}
