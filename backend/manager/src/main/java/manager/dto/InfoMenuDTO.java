package manager.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author yangguoqing
 */
@Data
public class InfoMenuDTO {

	private Integer id;

	private String menuName;

	private Integer parentMenuId;

	private String menuIconPath;

	private String menuLinkPath;

	private Set<InfoMenuDTO> children;
}

