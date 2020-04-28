package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.dto.InfoMenuDTO;
import manager.interactive.menu.AddMenuRequest;
import manager.interactive.menu.UpdateMenuRequest;
import manager.service.InfoMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * @author yangguoqing
 */
@Slf4j
@Api(tags = "菜单信息服务", value = "/menu/**")
@RestController
public class InfoMenuController {

	@ApiOperation("获取角色下所有菜单")
	@GetMapping("/menu/all/role")
	public Set<InfoMenuDTO> packAllMenuByRoleId(HttpServletRequest request) {
		Integer roleId = Integer.valueOf(request.getAttribute("roleId").toString());

		return menuInfoService.packAllMenuByRoleId(roleId);
	}

	@ApiOperation("获取所有的菜单信息")
	@GetMapping("/menu/all")
	public Set<InfoMenuDTO> packAll() {
		return menuInfoService.packAll();
	}

	@ApiOperation("编辑菜单信息")
	@PostMapping("/menu/update")
	public boolean updateMenuInfo(@Valid @RequestBody UpdateMenuRequest request) {
		@NotNull Integer id = request.getId();
		String menuIconPath = request.getMenuIconPath();
		String menuLinkPath = request.getMenuLinkPath();
		@NotEmpty String menuName = request.getMenuName();

		return menuInfoService.update(id, menuName, null, menuIconPath, menuLinkPath);
	}

	@ApiOperation("新增菜单信息")
	@PostMapping("/menu/add")
	public boolean addMenuInfo(@Valid @RequestBody AddMenuRequest request) {
		@NotEmpty String menuName = request.getMenuName();
		String menuIconPath = request.getMenuIconPath();
		String menuLinkPath = request.getMenuLinkPath();
		@NotNull Integer parentMenuId = request.getParentMenuId();

		return menuInfoService.add(menuName, parentMenuId, menuIconPath, menuLinkPath);
	}

	private InfoMenuService menuInfoService;

	@Autowired
	public void setMenuInfoService(InfoMenuService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}
}
