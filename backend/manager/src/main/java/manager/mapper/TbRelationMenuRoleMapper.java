package manager.mapper;

import manager.model.TbRelationMenuRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static manager.mapper.TbRelationMenuRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TbRelationMenuRoleMapper {
	@Insert({"<script>insert into tb_relation_menu_role( role_id, menu_id) values " +
			"<foreach collection='list' item='i' separator=','>(#{i.roleId},#{i.menuId})" +
			"</foreach> on duplicate key update relation_up= 1 - relation_up </script>"})
	void batchInsertRoleRelationMenu(@Param("list") List<TbRelationMenuRole> list);


	BasicColumn[] selectList = BasicColumn.columnList(id, roleId, menuId, relationUp, createTime, lastUpdateTime);


	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	long count(SelectStatementProvider selectStatement);


	@DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
	int delete(DeleteStatementProvider deleteStatement);


	@InsertProvider(type = SqlProviderAdapter.class, method = "insert")
	int insert(InsertStatementProvider<TbRelationMenuRole> insertStatement);


	@InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
	int insertMultiple(MultiRowInsertStatementProvider<TbRelationMenuRole> multipleInsertStatement);


	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@ResultMap("TbRelationMenuRoleResult")
	Optional<TbRelationMenuRole> selectOne(SelectStatementProvider selectStatement);


	@SelectProvider(type = SqlProviderAdapter.class, method = "select")
	@Results(id = "TbRelationMenuRoleResult", value = {
			@Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "role_id", property = "roleId", jdbcType = JdbcType.INTEGER),
			@Result(column = "menu_id", property = "menuId", jdbcType = JdbcType.INTEGER),
			@Result(column = "relation_up", property = "relationUp", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "last_update_time", property = "lastUpdateTime", jdbcType = JdbcType.TIMESTAMP)
	})
	List<TbRelationMenuRole> selectMany(SelectStatementProvider selectStatement);


	@UpdateProvider(type = SqlProviderAdapter.class, method = "update")
	int update(UpdateStatementProvider updateStatement);


	default long count(CountDSLCompleter completer) {
		return MyBatis3Utils.countFrom(this::count, tbRelationMenuRole, completer);
	}


	default int delete(DeleteDSLCompleter completer) {
		return MyBatis3Utils.deleteFrom(this::delete, tbRelationMenuRole, completer);
	}


	default int deleteByPrimaryKey(Integer id_) {
		return delete(c ->
				c.where(id, isEqualTo(id_))
		);
	}


	default int insert(TbRelationMenuRole record) {
		return MyBatis3Utils.insert(this::insert, record, tbRelationMenuRole, c ->
				c.map(id).toProperty("id")
						.map(roleId).toProperty("roleId")
						.map(menuId).toProperty("menuId")
						.map(relationUp).toProperty("relationUp")
						.map(createTime).toProperty("createTime")
						.map(lastUpdateTime).toProperty("lastUpdateTime")
		);
	}


	default int insertMultiple(Collection<TbRelationMenuRole> records) {
		return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbRelationMenuRole, c ->
				c.map(id).toProperty("id")
						.map(roleId).toProperty("roleId")
						.map(menuId).toProperty("menuId")
						.map(relationUp).toProperty("relationUp")
						.map(createTime).toProperty("createTime")
						.map(lastUpdateTime).toProperty("lastUpdateTime")
		);
	}


	default int insertSelective(TbRelationMenuRole record) {
		return MyBatis3Utils.insert(this::insert, record, tbRelationMenuRole, c ->
				c.map(id).toPropertyWhenPresent("id", record::getId)
						.map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
						.map(menuId).toPropertyWhenPresent("menuId", record::getMenuId)
						.map(relationUp).toPropertyWhenPresent("relationUp", record::getRelationUp)
						.map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
						.map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
		);
	}


	default Optional<TbRelationMenuRole> selectOne(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectOne(this::selectOne, selectList, tbRelationMenuRole, completer);
	}


	default List<TbRelationMenuRole> select(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectList(this::selectMany, selectList, tbRelationMenuRole, completer);
	}


	default List<TbRelationMenuRole> selectDistinct(SelectDSLCompleter completer) {
		return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbRelationMenuRole, completer);
	}


	default Optional<TbRelationMenuRole> selectByPrimaryKey(Integer id_) {
		return selectOne(c ->
				c.where(id, isEqualTo(id_))
		);
	}


	default int update(UpdateDSLCompleter completer) {
		return MyBatis3Utils.update(this::update, tbRelationMenuRole, completer);
	}


	static UpdateDSL<UpdateModel> updateAllColumns(TbRelationMenuRole record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalTo(record::getId)
				.set(roleId).equalTo(record::getRoleId)
				.set(menuId).equalTo(record::getMenuId)
				.set(relationUp).equalTo(record::getRelationUp)
				.set(createTime).equalTo(record::getCreateTime)
				.set(lastUpdateTime).equalTo(record::getLastUpdateTime);
	}


	static UpdateDSL<UpdateModel> updateSelectiveColumns(TbRelationMenuRole record, UpdateDSL<UpdateModel> dsl) {
		return dsl.set(id).equalToWhenPresent(record::getId)
				.set(roleId).equalToWhenPresent(record::getRoleId)
				.set(menuId).equalToWhenPresent(record::getMenuId)
				.set(relationUp).equalToWhenPresent(record::getRelationUp)
				.set(createTime).equalToWhenPresent(record::getCreateTime)
				.set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
	}


	default int updateByPrimaryKey(TbRelationMenuRole record) {
		return update(c ->
				c.set(roleId).equalTo(record::getRoleId)
						.set(menuId).equalTo(record::getMenuId)
						.set(relationUp).equalTo(record::getRelationUp)
						.set(createTime).equalTo(record::getCreateTime)
						.set(lastUpdateTime).equalTo(record::getLastUpdateTime)
						.where(id, isEqualTo(record::getId))
		);
	}


	default int updateByPrimaryKeySelective(TbRelationMenuRole record) {
		return update(c ->
				c.set(roleId).equalToWhenPresent(record::getRoleId)
						.set(menuId).equalToWhenPresent(record::getMenuId)
						.set(relationUp).equalToWhenPresent(record::getRelationUp)
						.set(createTime).equalToWhenPresent(record::getCreateTime)
						.set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
						.where(id, isEqualTo(record::getId))
		);
	}
}