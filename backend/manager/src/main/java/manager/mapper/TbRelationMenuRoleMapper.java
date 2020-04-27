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

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static manager.mapper.TbRelationMenuRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TbRelationMenuRoleMapper {
    @Insert({"<script>insert into tb_relation_menu_role( manager_role_id, config_menu_id) values " +
            "<foreach collection='list' item='i' separator=','>(#{i.managerRoleId},#{i.configMenuId})" +
            "</foreach> on duplicate key update relation_up= 1 - relation_up </script>"})
    void batchInsertRoleRelationMenu(@Param("list") List<TbRelationMenuRole> list);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    BasicColumn[] selectList = BasicColumn.columnList(id, managerRoleId, configMenuId, relationUp, createTime, lastUpdateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbRelationMenuRole> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbRelationMenuRole> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbRelationMenuRoleResult")
    Optional<TbRelationMenuRole> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbRelationMenuRoleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="manager_role_id", property="managerRoleId", jdbcType=JdbcType.INTEGER),
        @Result(column="config_menu_id", property="configMenuId", jdbcType=JdbcType.INTEGER),
        @Result(column="relation_up", property="relationUp", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbRelationMenuRole> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default int insert(TbRelationMenuRole record) {
        return MyBatis3Utils.insert(this::insert, record, tbRelationMenuRole, c ->
            c.map(id).toProperty("id")
            .map(managerRoleId).toProperty("managerRoleId")
            .map(configMenuId).toProperty("configMenuId")
            .map(relationUp).toProperty("relationUp")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default int insertMultiple(Collection<TbRelationMenuRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbRelationMenuRole, c ->
            c.map(id).toProperty("id")
            .map(managerRoleId).toProperty("managerRoleId")
            .map(configMenuId).toProperty("configMenuId")
            .map(relationUp).toProperty("relationUp")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default int insertSelective(TbRelationMenuRole record) {
        return MyBatis3Utils.insert(this::insert, record, tbRelationMenuRole, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(managerRoleId).toPropertyWhenPresent("managerRoleId", record::getManagerRoleId)
            .map(configMenuId).toPropertyWhenPresent("configMenuId", record::getConfigMenuId)
            .map(relationUp).toPropertyWhenPresent("relationUp", record::getRelationUp)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default Optional<TbRelationMenuRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default List<TbRelationMenuRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default List<TbRelationMenuRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default Optional<TbRelationMenuRole> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.544+08:00", comments="Source Table: tb_relation_menu_role")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbRelationMenuRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.545+08:00", comments="Source Table: tb_relation_menu_role")
    static UpdateDSL<UpdateModel> updateAllColumns(TbRelationMenuRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(managerRoleId).equalTo(record::getManagerRoleId)
                .set(configMenuId).equalTo(record::getConfigMenuId)
                .set(relationUp).equalTo(record::getRelationUp)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.545+08:00", comments="Source Table: tb_relation_menu_role")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbRelationMenuRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(managerRoleId).equalToWhenPresent(record::getManagerRoleId)
                .set(configMenuId).equalToWhenPresent(record::getConfigMenuId)
                .set(relationUp).equalToWhenPresent(record::getRelationUp)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.545+08:00", comments="Source Table: tb_relation_menu_role")
    default int updateByPrimaryKey(TbRelationMenuRole record) {
        return update(c ->
            c.set(managerRoleId).equalTo(record::getManagerRoleId)
            .set(configMenuId).equalTo(record::getConfigMenuId)
            .set(relationUp).equalTo(record::getRelationUp)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.545+08:00", comments="Source Table: tb_relation_menu_role")
    default int updateByPrimaryKeySelective(TbRelationMenuRole record) {
        return update(c ->
            c.set(managerRoleId).equalToWhenPresent(record::getManagerRoleId)
            .set(configMenuId).equalToWhenPresent(record::getConfigMenuId)
            .set(relationUp).equalToWhenPresent(record::getRelationUp)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}