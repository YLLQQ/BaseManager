package manager.model;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;

public class TbInfoRole implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.role_name")
    private String roleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source field: tb_info_role.last_update_time")
    private Date lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source Table: tb_info_role")
    private static final long serialVersionUID = 1L;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.role_name")
    public String getRoleName() {
        return roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.role_name")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.529+08:00", comments="Source field: tb_info_role.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source field: tb_info_role.last_update_time")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source field: tb_info_role.last_update_time")
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source Table: tb_info_role")
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
        TbInfoRole other = (TbInfoRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source Table: tb_info_role")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.53+08:00", comments="Source Table: tb_info_role")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}