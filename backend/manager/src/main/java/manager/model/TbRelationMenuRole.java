package manager.model;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class TbRelationMenuRole implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.957+08:00", comments="Source field: tb_relation_menu_role.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.role_id")
    private Integer roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.menu_id")
    private Integer menuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    private Integer relationUp;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    private Date lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source Table: tb_relation_menu_role")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.menu_id")
    public Integer getMenuId() {
        return menuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.menu_id")
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    public Integer getRelationUp() {
        return relationUp;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    public void setRelationUp(Integer relationUp) {
        this.relationUp = relationUp;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source Table: tb_relation_menu_role")
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
        TbRelationMenuRole other = (TbRelationMenuRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
                && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
                && (this.getRelationUp() == null ? other.getRelationUp() == null : this.getRelationUp().equals(other.getRelationUp()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.958+08:00", comments="Source Table: tb_relation_menu_role")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getRelationUp() == null) ? 0 : getRelationUp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-28T09:59:51.959+08:00", comments="Source Table: tb_relation_menu_role")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", menuId=").append(menuId);
        sb.append(", relationUp=").append(relationUp);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}