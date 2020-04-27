package manager.interactive.menu;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Data
public class AddMenuInfoRequest {

	@NotNull
	private Integer parentMenuId;

	@NotEmpty
	private String menuName;

	private String menuIconPath;

	private String menuLinkPath;
}