package manager.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TbInfoMenuDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source Table: tb_info_menu")
    public static final TbInfoMenu tbInfoMenu = new TbInfoMenu();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.id")
    public static final SqlColumn<Integer> id = tbInfoMenu.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.menu_name")
    public static final SqlColumn<String> menuName = tbInfoMenu.menuName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.parent_menu_id")
    public static final SqlColumn<Integer> parentMenuId = tbInfoMenu.parentMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.menu_icon_path")
    public static final SqlColumn<String> menuIconPath = tbInfoMenu.menuIconPath;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.menu_link_path")
    public static final SqlColumn<String> menuLinkPath = tbInfoMenu.menuLinkPath;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.create_time")
    public static final SqlColumn<Date> createTime = tbInfoMenu.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source field: tb_info_menu.last_update_time")
    public static final SqlColumn<Date> lastUpdateTime = tbInfoMenu.lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.926+08:00", comments="Source Table: tb_info_menu")
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