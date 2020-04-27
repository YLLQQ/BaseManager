package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbRelationMenuRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source Table: tb_relation_menu_role")
    public static final TbRelationMenuRole tbRelationMenuRole = new TbRelationMenuRole();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.id")
    public static final SqlColumn<Integer> id = tbRelationMenuRole.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.manager_role_id")
    public static final SqlColumn<Integer> managerRoleId = tbRelationMenuRole.managerRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.config_menu_id")
    public static final SqlColumn<Integer> configMenuId = tbRelationMenuRole.configMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    public static final SqlColumn<Integer> relationUp = tbRelationMenuRole.relationUp;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.create_time")
    public static final SqlColumn<Date> createTime = tbRelationMenuRole.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    public static final SqlColumn<Date> lastUpdateTime = tbRelationMenuRole.lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.543+08:00", comments="Source Table: tb_relation_menu_role")
    public static final class TbRelationMenuRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> managerRoleId = column("manager_role_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> configMenuId = column("config_menu_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> relationUp = column("relation_up", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public TbRelationMenuRole() {
            super("tb_relation_menu_role");
        }
    }
}