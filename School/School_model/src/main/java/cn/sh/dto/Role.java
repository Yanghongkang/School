package cn.sh.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cn.sh.dto.common.PageRetDto;

@Entity
@Table(name = "school_role")
public class Role extends PageRetDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // @id注意选择这个javax.persistence
	@GeneratedValue
	private Long id;
	private String roleName;
	private Date createDate;
	private Date updateDate;
	private String remark;
	private String islock;
	private Long seq;

	private List<Resource> resourceList;

	public String getIslock() {
		return islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", remark=" + remark + ", islock=" + islock + ", seq=" + seq + ", resourceList=" + resourceList + "]";
	}

}
