package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.dto.InfoRoleDTO;
import manager.interactive.role.AddRoleRequest;
import manager.interactive.role.UpdateRoleRequest;
import manager.service.InfoRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

	@ApiOperation("修改角色")
	@PostMapping("/role/update")
	public boolean update(@Valid @RequestBody UpdateRoleRequest request) {
		@NotNull Integer id = request.getId();
		@NotEmpty String roleName = request.getRoleName();

		return infoRoleService.update(id, roleName);
	}

	@ApiOperation("新增角色")
	@PostMapping("/role/add")
	public boolean add(@Valid @RequestBody AddRoleRequest request) {
		@NotEmpty String roleName = request.getRoleName();

		return infoRoleService.add(roleName);
	}

	@ApiOperation("获取系统所有的角色信息")
	@GetMapping("/role/all")
	public List<InfoRoleDTO> getAll() {
		return infoRoleService.getAll();
	}
}
