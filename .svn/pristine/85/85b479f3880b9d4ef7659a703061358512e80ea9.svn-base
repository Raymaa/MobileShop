package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Payment implements Serializable {
	private Integer payment_id;
	private String sn;
	private Integer paytype_id;
	private Double amount;
	private Integer status;//支付状态，0：创建，1：支付成功，2：支付失败
	private Timestamp paytime;
	private String remark;
	
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Integer getPaytype_id() {
		return paytype_id;
	}
	public void setPaytype_id(Integer paytype_id) {
		this.paytype_id = paytype_id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getPaytime() {
		return paytime;
	}
	public void setPaytime(Timestamp paytime) {
		this.paytime = paytime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", sn=" + sn + ", paytype_id=" + paytype_id + ", amount=" + amount
				+ ", status=" + status + ", paytime=" + paytime + ", remark=" + remark + "]";
	}
}
