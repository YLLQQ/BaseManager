package manager.service;

import manager.mapper.TbRelationMenuRoleMapper;
import manager.model.TbRelationMenuRole;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.unity.tool.util.CollectionUtil;

import java.util.List;
import java.util.stream.Collectors;

import static manager.mapper.TbRelationMenuRoleDynamicSqlSupport.*;
import static manager.response.ManagerCodeEnum.RELATION_MENU_ROLE_NOT_EXISTS;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.selectDistinct;

/**
 * @author yangguoqing
 */
@Service
public class RelationMenuRoleService {

	private static final Integer RELATION_UP = 1;

	public List<Integer> getAllMenuIdByRoleId(Integer iRoleId) {
		SelectStatementProvider selectStatementProvider =
				selectDistinct(menuId)
						.from(tbRelationMenuRole)
						.where(roleId, isEqualTo(iRoleId))
						.and(relationUp, isEqualTo(RELATION_UP))
						.build()
						.render(RenderingStrategies.MYBATIS3);

		List<TbRelationMenuRole> tbInfoMenus = tbRelationMenuRoleMapper.selectMany(selectStatementProvider);

		CollectionUtil.collectionIsNotEmpty(tbInfoMenus, RELATION_MENU_ROLE_NOT_EXISTS);

		List<Integer> menuIdList =
				tbInfoMenus.stream().map(item -> item.getMenuId()).collect(Collectors.toList());

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
