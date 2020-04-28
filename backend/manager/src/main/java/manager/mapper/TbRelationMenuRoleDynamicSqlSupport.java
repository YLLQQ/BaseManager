package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbRelationMenuRoleDynamicSqlSupport {

    public static final TbRelationMenuRole tbRelationMenuRole = new TbRelationMenuRole();


    public static final SqlColumn<Integer> id = tbRelationMenuRole.id;


    public static final SqlColumn<Integer> roleId = tbRelationMenuRole.roleId;


    public static final SqlColumn<Integer> menuId = tbRelationMenuRole.menuId;


    public static final SqlColumn<Integer> relationUp = tbRelationMenuRole.relationUp;


    public static final SqlColumn<Date> createTime = tbRelationMenuRole.createTime;


    public static final SqlColumn<Date> lastUpdateTime = tbRelationMenuRole.lastUpdateTime;


    public static final class TbRelationMenuRole extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleId = column("role_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> menuId = column("menu_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> relationUp = column("relation_up", JDBCType.INTEGER);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public TbRelationMenuRole() {
            super("tb_relation_menu_role");
        }
    }
}