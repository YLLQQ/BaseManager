package manager.model;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class TbRelationMenuRole implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.541+08:00", comments="Source field: tb_relation_menu_role.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.541+08:00", comments="Source field: tb_relation_menu_role.manager_role_id")
    private Integer managerRoleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.config_menu_id")
    private Integer configMenuId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    private Integer relationUp;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    private Date lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source Table: tb_relation_menu_role")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.541+08:00", comments="Source field: tb_relation_menu_role.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.541+08:00", comments="Source field: tb_relation_menu_role.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.manager_role_id")
    public Integer getManagerRoleId() {
        return managerRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.manager_role_id")
    public void setManagerRoleId(Integer managerRoleId) {
        this.managerRoleId = managerRoleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.config_menu_id")
    public Integer getConfigMenuId() {
        return configMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.config_menu_id")
    public void setConfigMenuId(Integer configMenuId) {
        this.configMenuId = configMenuId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    public Integer getRelationUp() {
        return relationUp;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.relation_up")
    public void setRelationUp(Integer relationUp) {
        this.relationUp = relationUp;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source field: tb_relation_menu_role.last_update_time")
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source Table: tb_relation_menu_role")
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
            && (this.getManagerRoleId() == null ? other.getManagerRoleId() == null : this.getManagerRoleId().equals(other.getManagerRoleId()))
            && (this.getConfigMenuId() == null ? other.getConfigMenuId() == null : this.getConfigMenuId().equals(other.getConfigMenuId()))
            && (this.getRelationUp() == null ? other.getRelationUp() == null : this.getRelationUp().equals(other.getRelationUp()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source Table: tb_relation_menu_role")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getManagerRoleId() == null) ? 0 : getManagerRoleId().hashCode());
        result = prime * result + ((getConfigMenuId() == null) ? 0 : getConfigMenuId().hashCode());
        result = prime * result + ((getRelationUp() == null) ? 0 : getRelationUp().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.542+08:00", comments="Source Table: tb_relation_menu_role")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", managerRoleId=").append(managerRoleId);
        sb.append(", configMenuId=").append(configMenuId);
        sb.append(", relationUp=").append(relationUp);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}