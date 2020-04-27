package manager.controller;

import manager.dto.InfoMenuDTO;
import manager.interactive.menu.AddMenuInfoRequest;
import manager.interactive.menu.UpdateMenuInfoRequest;
import manager.model.TbInfoMenu;
import manager.service.InfoMenuService;
import self.unity.tool.util.BeanCopierUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

/**
 * @author yangguoqing
 */
@Slf4j
@Api(tags = "菜单信息服务", value = "/menu/**")
@RestController
public class InfoMenuController {

	@ApiOperation("获取角色下所有菜单")
	@GetMapping("/menu/list")
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
	public boolean updateMenuInfo(@Valid @RequestBody UpdateMenuInfoRequest request) {
		TbInfoMenu tbInfoMenu = new TbInfoMenu();

		BeanCopierUtil.copyS2T(request, tbInfoMenu);

		int i = menuInfoService.updateMenuInfoById(tbInfoMenu);

		if (log.isDebugEnabled()) {
			log.debug("[ update menu, result is [{}] ]", i);
		}

		return i > 0;
	}

	@ApiOperation("新增菜单信息")
	@PostMapping("/menu/add")
	public boolean addMenuInfo(@Valid @RequestBody AddMenuInfoRequest request) {
		TbInfoMenu tbInfoMenu = new TbInfoMenu();

		BeanCopierUtil.copyS2T(request, tbInfoMenu);

		if (log.isDebugEnabled()) {
			log.debug("[ add menu, request is [{}], and tbInfoMenu is [{}]]", request, tbInfoMenu);
		}

		int i = menuInfoService.addMenuInfo(tbInfoMenu);

		if (log.isDebugEnabled()) {
			log.debug("[ add menu, result is [{}] ]", i);
		}

		return i > 0;
	}

	private InfoMenuService menuInfoService;

	@Autowired
	public void setMenuInfoService(InfoMenuService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}
}
