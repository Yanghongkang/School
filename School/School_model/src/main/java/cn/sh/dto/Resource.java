package cn.sh.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.sh.dto.common.CommonRetDto;
import cn.sh.dto.common.PageRetDto;

@Entity
@Table(name = "school_resource")
public class Resource extends CommonRetDto implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id // @id注意选择这个javax.persistence
	@GeneratedValue
	private Long id;
	private Long parentId;
	private String resourceName;
	private String resourceType;
	private String url;
	private String seq;
	private String islock;
	private Date createDate;
	private Date updateDate;

	private List<Resource> childResource;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getIslock() {
		return islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
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

	public List<Resource> getChildResource() {
		return childResource;
	}

	public void setChildResource(List<Resource> childResource) {
		this.childResource = childResource;
	}

	@Override
	public Resource clone() {
		Resource res = null;
		try {
			res = (Resource) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", parentId=" + parentId + ", resourceName=" + resourceName + ", resourceType="
				+ resourceType + ", url=" + url + ", seq=" + seq + ", islock=" + islock + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

}
