package manager.model;

import manager.util.EncryptUtil;

import java.io.Serializable;
import java.util.Date;

public class TbInfoManager implements Serializable {

	private Integer id;

	private String loginName;

	private String loginPassword;


	private Integer roleId;


	private Date createTime;


	private Date lastUpdateTime;


	private static final long serialVersionUID = 1L;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = EncryptUtil.md5(loginPassword);
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}


	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
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
				&& (this.getLoginName() == null ? other.getLoginName() == null :
				this.getLoginName().equals(other.getLoginName()))
				&& (this.getLoginPassword() == null ? other.getLoginPassword() == null :
				this.getLoginPassword().equals(other.getLoginPassword()))
				&& (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
				&& (this.getCreateTime() == null ? other.getCreateTime() == null :
				this.getCreateTime().equals(other.getCreateTime()))
				&& (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null :
				this.getLastUpdateTime().equals(other.getLastUpdateTime()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
		result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
		result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
		result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
		result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", loginName=").append(loginName);
		sb.append(", loginPassword=").append(loginPassword);
		sb.append(", roleId=").append(roleId);
		sb.append(", createTime=").append(createTime);
		sb.append(", lastUpdateTime=").append(lastUpdateTime);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}