package manager.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.util.Date;

public final class TbInfoManagerDynamicSqlSupport {

	public static final TbInfoManager tbInfoManager = new TbInfoManager();


	public static final SqlColumn<Integer> id = tbInfoManager.id;


	public static final SqlColumn<String> loginName = tbInfoManager.loginName;


	public static final SqlColumn<String> loginPassword = tbInfoManager.loginPassword;


	public static final SqlColumn<Integer> roleId = tbInfoManager.roleId;


	public static final SqlColumn<Date> createTime = tbInfoManager.createTime;


	public static final SqlColumn<Date> lastUpdateTime = tbInfoManager.lastUpdateTime;


	public static final class TbInfoManager extends SqlTable {
		public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

		public final SqlColumn<String> loginName = column("login_name", JDBCType.VARCHAR);

		public final SqlColumn<String> loginPassword = column("login_password", JDBCType.VARCHAR);

		public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

		public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

		public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

		public TbInfoManager() {
			super("tb_info_manager");
		}
	}
}