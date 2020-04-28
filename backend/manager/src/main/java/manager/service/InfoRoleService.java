package manager.service;

import manager.dto.InfoRoleDTO;
import manager.mapper.TbInfoRoleMapper;
import manager.model.TbInfoRole;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.unity.response.exception.UnifiedInteractiveException;
import self.unity.tool.util.BeanCopierUtil;
import self.unity.tool.util.CollectionUtil;
import self.unity.tool.util.MainUtil;

import java.util.List;

import static manager.mapper.TbInfoRoleDynamicSqlSupport.*;
import static manager.response.ManagerCodeEnum.ROLE_INFO_LIST_MISSING;
import static manager.response.ManagerCodeEnum.ROLE_INFO_NOT_EXISTS;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author yangguoqing
 */
@Service
public class InfoRoleService {

	public boolean update(Integer id, String roleName) {
		TbInfoRole tbInfoRole = new TbInfoRole();

		tbInfoRole.setId(id);
		tbInfoRole.setRoleName(roleName);

		int row = tbInfoRoleMapper.updateByPrimaryKeySelective(tbInfoRole);

		return MainUtil.insertOrUpdateSuccess(row);
	}

	public boolean add(String roleName) {
		TbInfoRole tbInfoRole = new TbInfoRole();

		tbInfoRole.setRoleName(roleName);

		int row = tbInfoRoleMapper.insertSelective(tbInfoRole);

		return MainUtil.insertOrUpdateSuccess(row);
	}

	public InfoRoleDTO getById(Integer id) {
		TbInfoRole tbInfoRole =
				tbInfoRoleMapper
						.selectByPrimaryKey(id)
						.orElseThrow(() -> new UnifiedInteractiveException(ROLE_INFO_NOT_EXISTS));

		return BeanCopierUtil.copyS2T(tbInfoRole, InfoRoleDTO.class);
	}

	public List<InfoRoleDTO> getAll() {
		SelectStatementProvider selectStatementProvider =
				select(id, roleName)
						.from(tbInfoRole)
						.orderBy(id)
						.build()
						.render(RenderingStrategies.MYBATIS3);

		List<TbInfoRole> tbInfoRoles =
				tbInfoRoleMapper.selectMany(selectStatementProvider);

		CollectionUtil.collectionIsNotEmpty(tbInfoRoles, ROLE_INFO_LIST_MISSING);

		return BeanCopierUtil.copyS2TList(tbInfoRoles, InfoRoleDTO.class);
	}

	private TbInfoRoleMapper tbInfoRoleMapper;

	@Autowired
	public void setTbInfoRoleMapper(TbInfoRoleMapper tbInfoRoleMapper) {
		this.tbInfoRoleMapper = tbInfoRoleMapper;
	}
}
