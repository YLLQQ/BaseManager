package manager.model;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class TbInfoMenu implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_name")
    private String menuName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.parent_menu_id")
    private Integer parentMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_icon_path")
    private String menuIconPath;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.menu_link_path")
    private String menuLinkPath;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.last_update_time")
    private Date lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source Table: tb_info_menu")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_name")
    public String getMenuName() {
        return menuName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_name")
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.parent_menu_id")
    public Integer getParentMenuId() {
        return parentMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.parent_menu_id")
    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_icon_path")
    public String getMenuIconPath() {
        return menuIconPath;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.924+08:00", comments="Source field: tb_info_menu.menu_icon_path")
    public void setMenuIconPath(String menuIconPath) {
        this.menuIconPath = menuIconPath;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.menu_link_path")
    public String getMenuLinkPath() {
        return menuLinkPath;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.menu_link_path")
    public void setMenuLinkPath(String menuLinkPath) {
        this.menuLinkPath = menuLinkPath;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.last_update_time")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source field: tb_info_menu.last_update_time")
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source Table: tb_info_menu")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbInfoMenu other = (TbInfoMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
                && (this.getParentMenuId() == null ? other.getParentMenuId() == null : this.getParentMenuId().equals(other.getParentMenuId()))
                && (this.getMenuIconPath() == null ? other.getMenuIconPath() == null : this.getMenuIconPath().equals(other.getMenuIconPath()))
                && (this.getMenuLinkPath() == null ? other.getMenuLinkPath() == null : this.getMenuLinkPath().equals(other.getMenuLinkPath()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source Table: tb_info_menu")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getParentMenuId() == null) ? 0 : getParentMenuId().hashCode());
        result = prime * result + ((getMenuIconPath() == null) ? 0 : getMenuIconPath().hashCode());
        result = prime * result + ((getMenuLinkPath() == null) ? 0 : getMenuLinkPath().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.925+08:00", comments="Source Table: tb_info_menu")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuName=").append(menuName);
        sb.append(", parentMenuId=").append(parentMenuId);
        sb.append(", menuIconPath=").append(menuIconPath);
        sb.append(", menuLinkPath=").append(menuLinkPath);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}