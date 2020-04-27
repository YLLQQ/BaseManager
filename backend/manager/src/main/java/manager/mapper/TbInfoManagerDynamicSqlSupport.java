package manager.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;

public final class TbInfoManagerDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
    public static final TbInfoManager tbInfoManager = new TbInfoManager();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.id")
    public static final SqlColumn<Integer> id = tbInfoManager.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.login_name")
    public static final SqlColumn<String> loginName = tbInfoManager.loginName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source field: tb_info_manager.login_password")
    public static final SqlColumn<String> loginPassword = tbInfoManager.loginPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source field: tb_info_manager.role_id")
    public static final SqlColumn<Integer> roleId = tbInfoManager.roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source field: tb_info_manager.company_id")
    public static final SqlColumn<Integer> companyId = tbInfoManager.companyId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source field: tb_info_manager.create_time")
    public static final SqlColumn<Date> createTime = tbInfoManager.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.535+08:00", comments="Source field: tb_info_manager.last_update_time")
    public static final SqlColumn<Date> lastUpdateTime = tbInfoManager.lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
    public static final class TbInfoManager extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> loginName = column("login_name", JDBCType.VARCHAR);

        public final SqlColumn<String> loginPassword = column("login_password", JDBCType.VARCHAR);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> companyId = column("company_id", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public TbInfoManager() {
            super("tb_info_manager");
        }
    }
}