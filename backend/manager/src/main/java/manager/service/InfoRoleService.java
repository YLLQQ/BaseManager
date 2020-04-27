package manager.service;

import jdk.nashorn.internal.objects.annotations.Setter;
import manager.mapper.TbInfoRoleMapper;
import manager.model.TbInfoRole;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static manager.mapper.TbInfoRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author yangguoqing
 */
@Service
public class InfoRoleService {

	public TbInfoRole getById(Integer id) {
		return tbInfoRoleMapper.selectByPrimaryKey(id).get();
	}

	public int add(TbInfoRole record) {
		return tbInfoRoleMapper.insertSelective(record);
	}

	public List<TbInfoRole> getAll() {
		SelectStatementProvider selectStatementProvider =
				select(id, roleName)
						.from(tbInfoRole)
						.orderBy(id)
						.build()
						.render(RenderingStrategies.MYBATIS3);

		return tbInfoRoleMapper.selectMany(selectStatementProvider);
	}

	private TbInfoRoleMapper tbInfoRoleMapper;

	@Setter
	public void setTbInfoRoleMapper(TbInfoRoleMapper tbInfoRoleMapper) {
		this.tbInfoRoleMapper = tbInfoRoleMapper;
	}
}
