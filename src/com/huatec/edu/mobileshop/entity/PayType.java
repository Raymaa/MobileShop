package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PayType implements Serializable {
	private Integer paytype_id;
	private String name;
	private String config;
	private String description;
	private Timestamp creatime;
	private Timestamp modifytime;
	
	public Integer getPaytype_id() {
		return paytype_id;
	}
	public void setPaytype_id(Integer paytype_id) {
		this.paytype_id = paytype_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String toString() {
		return "PayType [paytype_id=" + paytype_id + ", name=" + name + ", config=" + config + ", description="
				+ description + ", creatime=" + creatime + ", modifytime=" + modifytime + "]";
	}
	
}
