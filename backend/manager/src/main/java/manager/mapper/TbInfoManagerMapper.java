package manager.mapper;

import manager.model.TbInfoManager;
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

import static manager.mapper.TbInfoManagerDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TbInfoManagerMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    BasicColumn[] selectList = BasicColumn.columnList(id, loginName, loginPassword, roleId, companyId, createTime, lastUpdateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbInfoManager> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbInfoManager> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbInfoManagerResult")
    Optional<TbInfoManager> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbInfoManagerResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="login_password", property="loginPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="company_id", property="companyId", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbInfoManager> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    default int insert(TbInfoManager record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoManager, c ->
            c.map(id).toProperty("id")
            .map(loginName).toProperty("loginName")
            .map(loginPassword).toProperty("loginPassword")
            .map(roleId).toProperty("roleId")
            .map(companyId).toProperty("companyId")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source Table: tb_info_manager")
    default int insertMultiple(Collection<TbInfoManager> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbInfoManager, c ->
            c.map(id).toProperty("id")
            .map(loginName).toProperty("loginName")
            .map(loginPassword).toProperty("loginPassword")
            .map(roleId).toProperty("roleId")
            .map(companyId).toProperty("companyId")
            .map(createTime).toProperty("createTime")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default int insertSelective(TbInfoManager record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoManager, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(loginName).toPropertyWhenPresent("loginName", record::getLoginName)
            .map(loginPassword).toPropertyWhenPresent("loginPassword", record::getLoginPassword)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(companyId).toPropertyWhenPresent("companyId", record::getCompanyId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default Optional<TbInfoManager> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default List<TbInfoManager> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default List<TbInfoManager> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default Optional<TbInfoManager> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbInfoManager, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    static UpdateDSL<UpdateModel> updateAllColumns(TbInfoManager record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(loginName).equalTo(record::getLoginName)
                .set(loginPassword).equalTo(record::getLoginPassword)
                .set(roleId).equalTo(record::getRoleId)
                .set(companyId).equalTo(record::getCompanyId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbInfoManager record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(loginName).equalToWhenPresent(record::getLoginName)
                .set(loginPassword).equalToWhenPresent(record::getLoginPassword)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(companyId).equalToWhenPresent(record::getCompanyId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.536+08:00", comments="Source Table: tb_info_manager")
    default int updateByPrimaryKey(TbInfoManager record) {
        return update(c ->
            c.set(loginName).equalTo(record::getLoginName)
            .set(loginPassword).equalTo(record::getLoginPassword)
            .set(roleId).equalTo(record::getRoleId)
            .set(companyId).equalTo(record::getCompanyId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.537+08:00", comments="Source Table: tb_info_manager")
    default int updateByPrimaryKeySelective(TbInfoManager record) {
        return update(c ->
            c.set(loginName).equalToWhenPresent(record::getLoginName)
            .set(loginPassword).equalToWhenPresent(record::getLoginPassword)
            .set(roleId).equalToWhenPresent(record::getRoleId)
            .set(companyId).equalToWhenPresent(record::getCompanyId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(id, isEqualTo(record::getId))
        );
    }
}