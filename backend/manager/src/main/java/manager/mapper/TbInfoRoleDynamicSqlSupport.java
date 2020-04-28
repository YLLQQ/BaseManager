package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbInfoRoleDynamicSqlSupport {

    public static final TbInfoRole tbInfoRole = new TbInfoRole();


    public static final SqlColumn<Integer> id = tbInfoRole.id;


    public static final SqlColumn<String> roleName = tbInfoRole.roleName;


    public static final SqlColumn<Date> createTime = tbInfoRole.createTime;


    public static final SqlColumn<Date> lastUpdateTime = tbInfoRole.lastUpdateTime;


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