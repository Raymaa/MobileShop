package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefRole;

public class Admin implements Serializable {
	private Integer admin_id;
	private String username;
	private String password;
	private String email;
	private String real_name;
	private Integer sex;//性别，0:男，1:女
	private String mobile;
	private Integer role_id;
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间
	
	//关联属性
	private BriefRole briefRole;
	
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Timestamp getCreatime() {
		return creatime;
	}
	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}
	public Timestamp getModifytime() {
		return modifytime;
	}
	public void setModifytime(Timestamp modifytime) {
		this.modifytime = modifytime;
	}
	public BriefRole getBriefRole() {
		return briefRole;
	}
	public void setBriefRole(BriefRole briefRole) {
		this.briefRole = briefRole;
	}
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", real_name=" + real_name + ", sex=" + sex + ", mobile=" + mobile + ", role_id=" + role_id
				+ ", creatime=" + creatime + ", modifytime=" + modifytime + ", briefRole=" + briefRole + "]";
	}
}
