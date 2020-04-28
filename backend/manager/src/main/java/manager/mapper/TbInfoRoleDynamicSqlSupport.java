package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbInfoRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.93+08:00", comments="Source Table: tb_info_role")
    public static final TbInfoRole tbInfoRole = new TbInfoRole();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.93+08:00", comments="Source field: tb_info_role.id")
    public static final SqlColumn<Integer> id = tbInfoRole.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source field: tb_info_role.role_name")
    public static final SqlColumn<String> roleName = tbInfoRole.roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source field: tb_info_role.create_time")
    public static final SqlColumn<Date> createTime = tbInfoRole.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.931+08:00", comments="Source field: tb_info_role.last_update_time")
    public static final SqlColumn<Date> lastUpdateTime = tbInfoRole.lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.93+08:00", comments="Source Table: tb_info_role")
    public static final class TbInfoRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public TbInfoRole() {
            super("tb_info_role");
        }
    }
}