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

import cn.sh.dto.common.CommonRetDto;
import cn.sh.dto.common.PageRetDto;

@Entity
@Table(name = "school_user")
public class User extends PageRetDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id // @id注意选择这个javax.persistence
	@GeneratedValue
	private Long id;
	private String userName;
	private String userPassword;
	private String salt;
	private String commonPhone;
	private String urgentPhone;
	private String email;
	private String weChat;
	private String dingtalk;
	private Long age;
	private Date createDate;
	private Date updateDate;
	private Date lostLoginDate;
	private String islock;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "school_user_role", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "ID") })
	private List<Role> roelList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getCommonPhone() {
		return commonPhone;
	}

	public void setCommonPhone(String commonPhone) {
		this.commonPhone = commonPhone;
	}

	public String getUrgentPhone() {
		return urgentPhone;
	}

	public void setUrgentPhone(String urgentPhone) {
		this.urgentPhone = urgentPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getDingtalk() {
		return dingtalk;
	}

	public void setDingtalk(String dingtalk) {
		this.dingtalk = dingtalk;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
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

	public Date getLostLoginDate() {
		return lostLoginDate;
	}

	public void setLostLoginDate(Date lostLoginDate) {
		this.lostLoginDate = lostLoginDate;
	}

	public String getIslock() {
		return islock;
	}

	public void setIslock(String islock) {
		this.islock = islock;
	}

	public List<Role> getRoelList() {
		return roelList;
	}

	public void setRoelList(List<Role> roelList) {
		this.roelList = roelList;
	}

}
