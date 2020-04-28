package manager.model;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class TbInfoMenu implements Serializable {

    private Integer id;


    private String menuName;


    private Integer parentMenuId;


    private String menuIconPath;


    private String menuLinkPath;


    private Date createTime;


    private Date lastUpdateTime;


    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getMenuName() {
        return menuName;
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public Integer getParentMenuId() {
        return parentMenuId;
    }


    public void setParentMenuId(Integer parentMenuId) {
        this.parentMenuId = parentMenuId;
    }


    public String getMenuIconPath() {
        return menuIconPath;
    }


    public void setMenuIconPath(String menuIconPath) {
        this.menuIconPath = menuIconPath;
    }


    public String getMenuLinkPath() {
        return menuLinkPath;
    }


    public void setMenuLinkPath(String menuLinkPath) {
        this.menuLinkPath = menuLinkPath;
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