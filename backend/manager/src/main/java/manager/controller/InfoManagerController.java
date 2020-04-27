package manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import manager.common.annotation.IgnoreToken;
import manager.common.model.PageModel;
import manager.interactive.manager.GetManagerInfoByPasswordRequest;
import manager.interactive.manager.UpdateManagerPasswordRequest;
import manager.model.TbInfoManager;
import manager.service.InfoManagerService;
import manager.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yangguoqing
 */
@Slf4j
@Api(tags = "登录账号信息服务", value = "/manager/**")
@RestController
public class InfoManagerController {

	@ApiOperation("修改登录密码")
	@PostMapping("/manager/password/update")
	public boolean updatePassword(@Valid @RequestBody UpdateManagerPasswordRequest request) {
		@NotNull Integer managerId = request.getId();
		@NotEmpty String password = request.getPassword();

		return managerInfoService.updatePassword(managerId, password);
	}

	@ApiOperation("通过编号获取账户信息")
	@GetMapping("/manager/info/{managerId}")
	public TbInfoManager getById(@PathVariable("managerId") int managerId) {
		return managerInfoService.getById(managerId);
	}

	@ApiOperation("分页获取账户信息")
	@GetMapping("/manager/info/all")
	public PageModel<TbInfoManager> getAllWithPage(@RequestParam("page") int page, @RequestParam("size") int size) {
		return managerInfoService.getAllWithPage(page, size);
	}

	@IgnoreToken
	@ApiOperation("通过登录名和密码获取管理员信息")
	@PostMapping("/manager/info")
	public String getManagerInfoByPassword(@Valid @RequestBody GetManagerInfoByPasswordRequest request) {
		@NotBlank String loginName = request.getLoginName();
		String password = request.getPassword();

		log.debug("current encode password is {}", password);

		TbInfoManager managerInfo = managerInfoService.getManagerInfoByPassword(loginName, password);

		return TokenUtil.signWithJwt(managerInfo);
	}

	private InfoManagerService managerInfoService;

	@Autowired
	public void setManagerInfoService(InfoManagerService managerInfoService) {
		this.managerInfoService = managerInfoService;
	}
}
