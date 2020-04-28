package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbInfoMenuDynamicSqlSupport {

    public static final TbInfoMenu tbInfoMenu = new TbInfoMenu();


    public static final SqlColumn<Integer> id = tbInfoMenu.id;


    public static final SqlColumn<String> menuName = tbInfoMenu.menuName;


    public static final SqlColumn<Integer> parentMenuId = tbInfoMenu.parentMenuId;


    public static final SqlColumn<String> menuIconPath = tbInfoMenu.menuIconPath;


    public static final SqlColumn<String> menuLinkPath = tbInfoMenu.menuLinkPath;


    public static final SqlColumn<Date> createTime = tbInfoMenu.createTime;


    public static final SqlColumn<Date> lastUpdateTime = tbInfoMenu.lastUpdateTime;


    public static final class TbInfoMenu extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> menuName = column("menu_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> parentMenuId = column("parent_menu_id", JDBCType.INTEGER);

        public final SqlColumn<String> menuIconPath = column("menu_icon_path", JDBCType.VARCHAR);

        public final SqlColumn<String> menuLinkPath = column("menu_link_path", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public TbInfoMenu() {
            super("tb_info_menu");
        }
    }
}