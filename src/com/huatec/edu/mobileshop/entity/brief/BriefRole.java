package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;

public class BriefRole implements Serializable {
	private Integer role_id;
	private String name;
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "BriefRole [role_id=" + role_id + ", name=" + name + "]";
	}
}
