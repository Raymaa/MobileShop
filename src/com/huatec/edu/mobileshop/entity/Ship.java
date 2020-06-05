package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Ship implements Serializable {
	private Integer ship_id;
	private String name;
	private String code;
	private Timestamp creatime;
	private Timestamp modifytime;
	
	public Integer getShip_id() {
		return ship_id;
	}
	public void setShip_id(Integer ship_id) {
		this.ship_id = ship_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
		return "Ship [ship_id=" + ship_id + ", name=" + name + ", code=" + code + ", creatime=" + creatime
				+ ", modifytime=" + modifytime + "]";
	}
}
