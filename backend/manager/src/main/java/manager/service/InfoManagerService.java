package manager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import manager.common.model.PageModel;
import manager.mapper.TbInfoManagerMapper;
import manager.model.TbInfoManager;
import manager.model.TbInfoRole;
import manager.util.EncryptUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.unity.response.enums.UnifiedResponseCodeEnum;
import self.unity.response.exception.UnifiedInteractiveException;

import java.util.List;
import java.util.Optional;

import static manager.mapper.TbInfoManagerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * @author yangguoqing
 */
@Service
public class InfoManagerService {

	public boolean updatePassword(Integer managerId, String password) {
		password = EncryptUtil.md5(password);

		TbInfoManager tbInfoManager = new TbInfoManager();

		tbInfoManager.setId(managerId);
		tbInfoManager.setLoginPassword(password);

		return tbInfoManagerMapper.updateByPrimaryKeySelective(tbInfoManager) > 0;
	}

	public TbInfoManager getById(Integer managerId) {
		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId, companyId)
				.from(tbInfoManager)
				.where(id, isEqualTo(managerId))
				.build()
				.render(RenderingStrategies.MYBATIS3);

		TbInfoManager infoManager = tbInfoManagerMapper.selectOne(selectStatementProvider).get();

		TbInfoRole role = infoRoleService.getById(infoManager.getRoleId());

		infoManager.setRoleName(role.getRoleName());

		return infoManager;
	}

	public PageModel<TbInfoManager> getAllWithPage(int page, int size) {
		PageHelper.startPage(page, size);

		List<TbInfoManager> list = getAll();

		PageInfo<TbInfoManager> pageInfo = new PageInfo<>(list);
		PageModel<TbInfoManager> pageModel = new PageModel<>();

		pageModel.setList(list);
		pageModel.setTotal(pageInfo.getTotal());
		pageModel.setPageNum(pageInfo.getPageNum());
		pageModel.setPageSize(size);

		return pageModel;
	}

	public List<TbInfoManager> getAll() {
		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId, companyId)
				.from(tbInfoManager)
				.build()
				.render(RenderingStrategies.MYBATIS3);

		return tbInfoManagerMapper.selectMany(selectStatementProvider);
	}

	public boolean add(TbInfoManager tbInfoManager) {
		tbInfoManager.setLoginPassword(EncryptUtil.md5(tbInfoManager.getLoginPassword()));

		return tbInfoManagerMapper.insertSelective(tbInfoManager) > 0;
	}

	/**
	 * 通过登录名和密码获取管理员信息
	 *
	 * @param iLoginName
	 * @param password
	 *
	 * @return
	 */
	public TbInfoManager getManagerInfoByPassword(String iLoginName, String password) {
		password = EncryptUtil.md5(password);

		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId, companyId)
				.from(tbInfoManager)
				.where(loginName, isEqualTo(iLoginName))
				.and(loginPassword, isEqualTo(password))
				.build()
				.render(RenderingStrategies.MYBATIS3);

		Optional<TbInfoManager> tbInfoManager = tbInfoManagerMapper.selectOne(selectStatementProvider);

		return tbInfoManager.orElseThrow(() -> new UnifiedInteractiveException(UnifiedResponseCodeEnum.MANAGER_INFO_NOT_EXISTS_WITH_PASSWORD));
	}

	private InfoRoleService infoRoleService;

	@Autowired
	public void setInfoRoleService(InfoRoleService infoRoleService) {
		this.infoRoleService = infoRoleService;
	}

	private TbInfoManagerMapper tbInfoManagerMapper;

	@Autowired
	public void setTbInfoManagerMapper(TbInfoManagerMapper tbInfoManagerMapper) {
		this.tbInfoManagerMapper = tbInfoManagerMapper;
	}

}
