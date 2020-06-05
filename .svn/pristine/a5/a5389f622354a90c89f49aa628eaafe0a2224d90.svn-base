package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Logi implements Serializable {
	private Integer logi_id;
	private Integer ship_id;
	private String sn;
	private Double carriage;//运费
	private String sender;//送货人
	private Integer status;//物流状态，0：创建，1：发货，2：确认收货
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间，发货时间
	
	public Integer getLogi_id() {
		return logi_id;
	}
	public void setLogi_id(Integer logi_id) {
		this.logi_id = logi_id;
	}
	public Integer getShip_id() {
		return ship_id;
	}
	public void setShip_id(Integer ship_id) {
		this.ship_id = ship_id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Double getCarriage() {
		return carriage;
	}
	public void setCarriage(Double carriage) {
		this.carriage = carriage;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		return "Logi [logi_id=" + logi_id + ", ship_id=" + ship_id + ", sn=" + sn + ", carriage=" + carriage
				+ ", sender=" + sender + ", status=" + status + ", creatime=" + creatime + ", modifytime=" + modifytime
				+ "]";
	}
}
