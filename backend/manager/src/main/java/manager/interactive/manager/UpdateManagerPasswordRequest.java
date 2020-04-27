package manager.interactive.manager;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Data
public class UpdateManagerPasswordRequest {

	@NotNull
	private Integer id;

	@NotEmpty
	private String password;
}
