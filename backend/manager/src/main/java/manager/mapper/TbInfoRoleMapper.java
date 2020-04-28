package manager.mapper;

import static manager.mapper.TbInfoRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import manager.model.TbInfoRole;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface TbInfoRoleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    BasicColumn[] selectList = BasicColumn.columnList(id, roleName, createTime, lastUpdateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbInfoRole> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbInfoRole> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbInfoRoleResult")
    Optional<TbInfoRole> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbInfoRoleResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbInfoRole> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source Table: tb_info_role")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int insert(TbInfoRole record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoRole, c ->
                c.map(id).toProperty("id")
                        .map(roleName).toProperty("roleName")
                        .map(createTime).toProperty("createTime")
                        .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int insertMultiple(Collection<TbInfoRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbInfoRole, c ->
                c.map(id).toProperty("id")
                        .map(roleName).toProperty("roleName")
                        .map(createTime).toProperty("createTime")
                        .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int insertSelective(TbInfoRole record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoRole, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(roleName).toPropertyWhenPresent("roleName", record::getRoleName)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default Optional<TbInfoRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default List<TbInfoRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default List<TbInfoRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default Optional<TbInfoRole> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.932+08:00", comments="Source Table: tb_info_role")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbInfoRole, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.933+08:00", comments="Source Table: tb_info_role")
    static UpdateDSL<UpdateModel> updateAllColumns(TbInfoRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(roleName).equalTo(record::getRoleName)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.933+08:00", comments="Source Table: tb_info_role")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbInfoRole record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(roleName).equalToWhenPresent(record::getRoleName)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.933+08:00", comments="Source Table: tb_info_role")
    default int updateByPrimaryKey(TbInfoRole record) {
        return update(c ->
                c.set(roleName).equalTo(record::getRoleName)
                        .set(createTime).equalTo(record::getCreateTime)
                        .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
                        .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.933+08:00", comments="Source Table: tb_info_role")
    default int updateByPrimaryKeySelective(TbInfoRole record) {
        return update(c ->
                c.set(roleName).equalToWhenPresent(record::getRoleName)
                        .set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
                        .where(id, isEqualTo(record::getId))
        );
    }
}