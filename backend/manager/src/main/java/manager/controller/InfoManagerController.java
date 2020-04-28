package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.common.annotation.IgnoreToken;
import manager.common.model.PageModel;
import manager.dto.InfoManagerDTO;
import manager.interactive.manager.AddManagerRequest;
import manager.interactive.manager.GetManagerInfoByPasswordRequest;
import manager.interactive.manager.UpdateManagerRequest;
import manager.service.InfoManagerService;
import manager.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Slf4j
@Api(tags = "登录账号信息服务", value = "/manager/**")
@RestController
public class InfoManagerController {

	@ApiOperation("增加账户信息")
	@PostMapping("/manager/add")
	public boolean add(@Valid @RequestBody AddManagerRequest request) {
		@NotBlank String loginName = request.getLoginName();
		@NotBlank String password = request.getPassword();
		@NotNull Integer roleId = request.getRoleId();

		return managerInfoService.add(loginName, password, roleId);
	}

	@ApiOperation("修改登录密码")
	@PostMapping("/manager/update")
	public boolean updatePassword(@Valid @RequestBody UpdateManagerRequest request) {
		@NotNull Integer managerId = request.getId();
		@NotBlank String loginName = request.getLoginName();
		@NotBlank String password = request.getPassword();
		@NotNull Integer roleId = request.getRoleId();

		return managerInfoService.update(managerId, password, loginName, roleId);
	}

	@ApiOperation("通过编号获取账户信息")
	@GetMapping("/manager/{managerId}")
	public InfoManagerDTO getById(@PathVariable("managerId") int managerId) {
		return managerInfoService.getById(managerId);
	}

	@ApiOperation("分页获取账户信息")
	@GetMapping("/manager/all")
	public PageModel<InfoManagerDTO> getAllWithPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		return managerInfoService.getAllWithPage(page, size);
	}

	@IgnoreToken
	@ApiOperation("通过登录名和密码获取管理员信息")
	@PostMapping("/manager/login")
	public String getManagerInfoByPassword(@Valid @RequestBody GetManagerInfoByPasswordRequest request) {
		@NotBlank String loginName = request.getLoginName();
		String password = request.getPassword();

		InfoManagerDTO managerInfo = managerInfoService.getManagerInfoByPassword(loginName, password);

		return TokenUtil.signWithJwt(managerInfo);
	}

	private InfoManagerService managerInfoService;

	@Autowired
	public void setManagerInfoService(InfoManagerService managerInfoService) {
		this.managerInfoService = managerInfoService;
	}
}
