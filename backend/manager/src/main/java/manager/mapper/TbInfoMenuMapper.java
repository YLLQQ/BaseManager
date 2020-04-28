package manager.mapper;

import manager.model.TbInfoMenu;
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

import static manager.mapper.TbInfoMenuDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TbInfoMenuMapper {

    BasicColumn[] selectList = BasicColumn.columnList(id, menuName, parentMenuId, menuIconPath, menuLinkPath, createTime, lastUpdateTime);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);


    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TbInfoMenu> insertStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TbInfoMenu> multipleInsertStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TbInfoMenuResult")
    Optional<TbInfoMenu> selectOne(SelectStatementProvider selectStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TbInfoMenuResult", value = {
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
            @Result(column="parent_menu_id", property="parentMenuId", jdbcType=JdbcType.INTEGER),
            @Result(column="menu_icon_path", property="menuIconPath", jdbcType=JdbcType.VARCHAR),
            @Result(column="menu_link_path", property="menuLinkPath", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<TbInfoMenu> selectMany(SelectStatementProvider selectStatement);


    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);


    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, tbInfoMenu, completer);
    }


    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, tbInfoMenu, completer);
    }


    default int deleteByPrimaryKey(Integer id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }


    default int insert(TbInfoMenu record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoMenu, c ->
                c.map(id).toProperty("id")
                        .map(menuName).toProperty("menuName")
                        .map(parentMenuId).toProperty("parentMenuId")
                        .map(menuIconPath).toProperty("menuIconPath")
                        .map(menuLinkPath).toProperty("menuLinkPath")
                        .map(createTime).toProperty("createTime")
                        .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }


    default int insertMultiple(Collection<TbInfoMenu> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, tbInfoMenu, c ->
                c.map(id).toProperty("id")
                        .map(menuName).toProperty("menuName")
                        .map(parentMenuId).toProperty("parentMenuId")
                        .map(menuIconPath).toProperty("menuIconPath")
                        .map(menuLinkPath).toProperty("menuLinkPath")
                        .map(createTime).toProperty("createTime")
                        .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }


    default int insertSelective(TbInfoMenu record) {
        return MyBatis3Utils.insert(this::insert, record, tbInfoMenu, c ->
                c.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(menuName).toPropertyWhenPresent("menuName", record::getMenuName)
                        .map(parentMenuId).toPropertyWhenPresent("parentMenuId", record::getParentMenuId)
                        .map(menuIconPath).toPropertyWhenPresent("menuIconPath", record::getMenuIconPath)
                        .map(menuLinkPath).toPropertyWhenPresent("menuLinkPath", record::getMenuLinkPath)
                        .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                        .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }


    default Optional<TbInfoMenu> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, tbInfoMenu, completer);
    }


    default List<TbInfoMenu> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, tbInfoMenu, completer);
    }


    default List<TbInfoMenu> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, tbInfoMenu, completer);
    }


    default Optional<TbInfoMenu> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }


    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, tbInfoMenu, completer);
    }


    static UpdateDSL<UpdateModel> updateAllColumns(TbInfoMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(menuName).equalTo(record::getMenuName)
                .set(parentMenuId).equalTo(record::getParentMenuId)
                .set(menuIconPath).equalTo(record::getMenuIconPath)
                .set(menuLinkPath).equalTo(record::getMenuLinkPath)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }


    static UpdateDSL<UpdateModel> updateSelectiveColumns(TbInfoMenu record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(menuName).equalToWhenPresent(record::getMenuName)
                .set(parentMenuId).equalToWhenPresent(record::getParentMenuId)
                .set(menuIconPath).equalToWhenPresent(record::getMenuIconPath)
                .set(menuLinkPath).equalToWhenPresent(record::getMenuLinkPath)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }


    default int updateByPrimaryKey(TbInfoMenu record) {
        return update(c ->
                c.set(menuName).equalTo(record::getMenuName)
                        .set(parentMenuId).equalTo(record::getParentMenuId)
                        .set(menuIconPath).equalTo(record::getMenuIconPath)
                        .set(menuLinkPath).equalTo(record::getMenuLinkPath)
                        .set(createTime).equalTo(record::getCreateTime)
                        .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
                        .where(id, isEqualTo(record::getId))
        );
    }


    default int updateByPrimaryKeySelective(TbInfoMenu record) {
        return update(c ->
                c.set(menuName).equalToWhenPresent(record::getMenuName)
                        .set(parentMenuId).equalToWhenPresent(record::getParentMenuId)
                        .set(menuIconPath).equalToWhenPresent(record::getMenuIconPath)
                        .set(menuLinkPath).equalToWhenPresent(record::getMenuLinkPath)
                        .set(createTime).equalToWhenPresent(record::getCreateTime)
                        .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
                        .where(id, isEqualTo(record::getId))
        );
    }
}