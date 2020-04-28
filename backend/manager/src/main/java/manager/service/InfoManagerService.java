package manager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import manager.common.model.PageModel;
import manager.dto.InfoManagerDTO;
import manager.dto.InfoRoleDTO;
import manager.mapper.TbInfoManagerMapper;
import manager.model.TbInfoManager;
import manager.response.ManagerCodeEnum;
import manager.util.EncryptUtil;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.unity.response.exception.UnifiedInteractiveException;
import self.unity.tool.util.BeanCopierUtil;
import self.unity.tool.util.CollectionUtil;
import self.unity.tool.util.MainUtil;

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

	public InfoManagerDTO getById(Integer managerId) {
		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId)
				.from(tbInfoManager)
				.where(id, isEqualTo(managerId))
				.build()
				.render(RenderingStrategies.MYBATIS3);

		Optional<TbInfoManager> tbInfoManager = tbInfoManagerMapper.selectOne(selectStatementProvider);

		TbInfoManager infoManager =
				tbInfoManager.orElseThrow(() -> new UnifiedInteractiveException(ManagerCodeEnum.MANAGER_INFO_NOT_EXISTS));

		InfoRoleDTO role = infoRoleService.getById(infoManager.getRoleId());

		InfoManagerDTO infoManagerDTO = BeanCopierUtil.copyS2T(infoManager, InfoManagerDTO.class);

		infoManagerDTO.setRoleName(role.getRoleName());

		return infoManagerDTO;
	}

	public PageModel<InfoManagerDTO> getAllWithPage(int page, int size) {
		PageHelper.startPage(page, size);

		List<TbInfoManager> list = getAll();

		PageInfo<TbInfoManager> pageInfo = new PageInfo<>(list);

		PageModel<InfoManagerDTO> pageModel = new PageModel<>();

		pageModel.setList(BeanCopierUtil.copyS2TList(list, InfoManagerDTO.class));
		pageModel.setTotal(pageInfo.getTotal());
		pageModel.setPageNum(pageInfo.getPageNum());
		pageModel.setPageSize(size);

		return pageModel;
	}

	public List<TbInfoManager> getAll() {
		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId)
				.from(tbInfoManager)
				.build()
				.render(RenderingStrategies.MYBATIS3);

		List<TbInfoManager> tbInfoManagers = tbInfoManagerMapper.selectMany(selectStatementProvider);

		CollectionUtil.collectionIsNotEmpty(tbInfoManagers, ManagerCodeEnum.MANAGER_INFO_LIST_MISSING);

		return tbInfoManagers;
	}

	public InfoManagerDTO getManagerInfoByPassword(String iLoginName, String password) {
		password = EncryptUtil.md5(password);

		SelectStatementProvider selectStatementProvider = select(id, loginName, roleId)
				.from(tbInfoManager)
				.where(loginName, isEqualTo(iLoginName))
				.and(loginPassword, isEqualTo(password))
				.build()
				.render(RenderingStrategies.MYBATIS3);

		TbInfoManager tbInfoManager =
				tbInfoManagerMapper
						.selectOne(selectStatementProvider)
						.orElseThrow(() -> new UnifiedInteractiveException(ManagerCodeEnum.MANAGER_INFO_NOT_EXISTS_WITH_PASSWORD));

		return BeanCopierUtil.copyS2T(tbInfoManager, InfoManagerDTO.class);
	}

	public boolean update(Integer managerId, String password) {
		return update(managerId, password, null, null);
	}

	public boolean update(Integer managerId, String password, String loginName, Integer roleId) {
		TbInfoManager tbInfoManager = new TbInfoManager();

		tbInfoManager.setId(managerId);
		tbInfoManager.setLoginPassword(password);
		tbInfoManager.setLoginName(loginName);
		tbInfoManager.setRoleId(roleId);

		int row = tbInfoManagerMapper.updateByPrimaryKeySelective(tbInfoManager);

		return MainUtil.insertOrUpdateSuccess(row);
	}

	public boolean add(String loginName, String loginPassword, Integer roleId) {
		TbInfoManager tbInfoManager = new TbInfoManager();

		tbInfoManager.setLoginName(loginName);
		tbInfoManager.setLoginPassword(loginPassword);
		tbInfoManager.setRoleId(roleId);

		int row = tbInfoManagerMapper.insertSelective(tbInfoManager);

		return MainUtil.insertOrUpdateSuccess(row);
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
