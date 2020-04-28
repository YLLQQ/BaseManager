package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.interactive.relation.UpdateRoleMenuRequest;
import manager.model.TbRelationMenuRole;
import manager.service.InfoMenuService;
import manager.service.RelationMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangguoqing
 */
@Slf4j
@RestController
@Api(tags = "菜单角色关系信息服务", value = "/relation/**")
public class RelationMenuRoleController {

	@ApiOperation("通过角色ID获取角色关联的底级菜单列表")
	@GetMapping("/relation/allMenuId/{roleId}")
	public List<Integer> getAllMenuIdByRoleId(@PathVariable("roleId") Integer roleId) {
		return relationMenuRoleService.getAllMenuIdByRoleId(roleId);
	}

	@ApiOperation("编辑角色拥有的菜单")
	@PostMapping("/relation/menuRole/update")
	public boolean updateRoleRelationMenu(@Valid @RequestBody UpdateRoleMenuRequest request) {
		@NotEmpty.List({}) List<Integer> menuIdList = request.getMenuIdList();
		@NotNull Integer roleId = request.getId();

		List<Integer> allParentId = menuInfoService.getAllParentId();

		List<Integer> reduceList =
				menuIdList.stream().filter(item -> !allParentId.contains(item)).collect(Collectors.toList());

		List<TbRelationMenuRole> menuRoleList = new ArrayList<>(reduceList.size());

		reduceList.forEach(id -> {
			TbRelationMenuRole tbRelationMenuRole = new TbRelationMenuRole();

			tbRelationMenuRole.setRoleId(roleId);
			tbRelationMenuRole.setMenuId(id);

			menuRoleList.add(tbRelationMenuRole);
		});


		if (log.isDebugEnabled()) {
			log.debug("[ request menu id list is [{}], all parent id list is [{}], reduce list is [{}]]",
					menuIdList, allParentId, reduceList);
		}

		relationMenuRoleService.batchInsertRoleRelationMenu(menuRoleList);

		return true;
	}

	private InfoMenuService menuInfoService;

	@Autowired
	public void setMenuInfoService(InfoMenuService menuInfoService) {
		this.menuInfoService = menuInfoService;
	}

	private RelationMenuRoleService relationMenuRoleService;

	@Autowired
	public void setRelationMenuRoleService(RelationMenuRoleService relationMenuRoleService) {
		this.relationMenuRoleService = relationMenuRoleService;
	}
}
