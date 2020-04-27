package manager.interactive.role;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author yangguoqing
 */
@Data
public class UpdateRoleMenuRequest {

	@NotNull
	private Integer id;

	@NotEmpty.List({})
	private List<Integer> menuIdList;

}
