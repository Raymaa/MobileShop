package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefGoods;

public class Cart implements Serializable {
	private Integer cart_id;
	private Integer member_id;
	private Integer goods_id;
	private Integer goods_num;
	private Integer choose;//0:选择，1：不选择
	private Double amount;
	private Timestamp creatime;
	private Timestamp modifytime;
	
	//关联属性
	private BriefGoods briefGoods;
	
	public Integer getCart_id() {
		return cart_id;
	}
	public void setCart_id(Integer cart_id) {
		this.cart_id = cart_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public Integer getChoose() {
		return choose;
	}
	public void setChoose(Integer choose) {
		this.choose = choose;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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
	
	public BriefGoods getBriefGoods() {
		return briefGoods;
	}
	public void setBriefGoods(BriefGoods briefGoods) {
		this.briefGoods = briefGoods;
	}
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", member_id=" + member_id + ", goods_id=" + goods_id + ", goods_num="
				+ goods_num + ", choose=" + choose + ", amount=" + amount + ", creatime=" + creatime + ", modifytime="
				+ modifytime + ", briefGoods=" + briefGoods + "]";
	}
	
}
