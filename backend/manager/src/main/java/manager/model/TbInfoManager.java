package manager.model;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class TbInfoManager implements Serializable {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_name")
    private String loginName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_password")
    private String loginPassword;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.role_id")
    private Integer roleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.company_id")
    private Integer companyId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.create_time")
    private Date createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.last_update_time")
    private Date lastUpdateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
    private static final long serialVersionUID = 1L;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_name")
    public String getLoginName() {
        return loginName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_name")
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_password")
    public String getLoginPassword() {
        return loginPassword;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.login_password")
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.role_id")
    public Integer getRoleId() {
        return roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.533+08:00", comments="Source field: tb_info_manager.role_id")
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.company_id")
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.create_time")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.create_time")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.last_update_time")
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source field: tb_info_manager.last_update_time")
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
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
        TbInfoManager other = (TbInfoManager) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getLoginPassword() == null ? other.getLoginPassword() == null : this.getLoginPassword().equals(other.getLoginPassword()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-04-27T16:05:45.534+08:00", comments="Source Table: tb_info_manager")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", roleId=").append(roleId);
        sb.append(", companyId=").append(companyId);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}