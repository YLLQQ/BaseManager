package manager.service;

import manager.mapper.TbRelationMenuRoleMapper;
import manager.model.TbRelationMenuRole;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static manager.mapper.TbRelationMenuRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.selectDistinct;

/**
 * @author yangguoqing
 */
@Service
public class RelationMenuRoleService {

	public List<Integer> getAllMenuIdByRoleId(Integer roleId) {
		SelectStatementProvider selectStatementProvider =
				selectDistinct(configMenuId)
						.from(tbRelationMenuRole)
						.where(managerRoleId, isEqualTo(roleId))
						.and(relationUp, isEqualTo(1))
						.build()
						.render(RenderingStrategies.MYBATIS3);

		List<TbRelationMenuRole> tbInfoMenus = tbRelationMenuRoleMapper.selectMany(selectStatementProvider);

		List<Integer> menuIdList =
				tbInfoMenus.stream().map(item -> item.getConfigMenuId()).collect(Collectors.toList());

		return menuIdList;
	}

	public void batchInsertRoleRelationMenu(List<TbRelationMenuRole> list) {
		tbRelationMenuRoleMapper.batchInsertRoleRelationMenu(list);
	}

	private TbRelationMenuRoleMapper tbRelationMenuRoleMapper;

	@Autowired
	public void setTbRelationMenuRoleMapper(TbRelationMenuRoleMapper tbRelationMenuRoleMapper) {
		this.tbRelationMenuRoleMapper = tbRelationMenuRoleMapper;
	}
}
