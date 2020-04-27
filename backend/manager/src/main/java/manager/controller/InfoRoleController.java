package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.interactive.role.AddRoleManagerRequest;
import manager.model.TbInfoRole;
import manager.service.InfoRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yangguoqing
 */
@Slf4j
@Api(tags = "管理员角色信息服务", value = "/role/**")
@RestController
public class InfoRoleController {

	private InfoRoleService infoRoleService;

	@Autowired
	public void setInfoRoleService(InfoRoleService infoRoleService) {
		this.infoRoleService = infoRoleService;
	}

	@ApiOperation("新增角色名称")
	@PostMapping("/role/manager/add")
	public boolean addRoleManagerWithCheck(@Valid @RequestBody AddRoleManagerRequest request) {
		TbInfoRole tbInfoRole = new TbInfoRole();

		tbInfoRole.setRoleName(request.getManagerRoleName());

		return infoRoleService.add(tbInfoRole) > 1;
	}

	@ApiOperation("获取系统所有的角色信息")
	@GetMapping("/role/manager/all")
	public List<TbInfoRole> getAll() {
		return infoRoleService.getAll();
	}
}
