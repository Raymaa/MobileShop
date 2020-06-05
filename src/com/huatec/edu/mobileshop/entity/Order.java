package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.huatec.edu.mobileshop.entity.brief.BriefLogi;
import com.huatec.edu.mobileshop.entity.brief.BriefMember;

public class Order implements Serializable {
	private Integer order_id;
	private String sn;
	private Integer member_id;//会员id
	/*
	 * status,订单状态
	 * 0：创建（待付款）
	 * 1：付款（待发货）
	 * 2：发货（待收货）
	 * 3：收货（完成）
	 * 4：取消
	 */
	private Integer status;
	private Integer payment_id;//支付id
	private Integer logi_id;//物流id
	private Double total_amount;
	private Integer address_id;//收货地址id
	private Timestamp creatime;
	private Timestamp modifytime;
	
	//关联属性
	private BriefLogi bl;
	private List<OrderGoods> ogs;
	private BriefMember bm;
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}
	public Integer getLogi_id() {
		return logi_id;
	}
	public void setLogi_id(Integer logi_id) {
		this.logi_id = logi_id;
	}
	public Double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
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
	
	public BriefLogi getBl() {
		return bl;
	}
	public void setBl(BriefLogi bl) {
		this.bl = bl;
	}
	public List<OrderGoods> getOgs() {
		return ogs;
	}
	public void setOgs(List<OrderGoods> ogs) {
		this.ogs = ogs;
	}
	
	public BriefMember getBm() {
		return bm;
	}
	public void setBm(BriefMember bm) {
		this.bm = bm;
	}
	public String toString() {
		return "Order [order_id=" + order_id + ", sn=" + sn + ", member_id=" + member_id + ", status=" + status
				+ ", payment_id=" + payment_id + ", logi_id=" + logi_id + ", total_amount=" + total_amount
				+ ", address_id=" + address_id + ", creatime=" + creatime + ", modifytime=" + modifytime + ", bl=" + bl
				+ ", ogs=" + ogs + ", bm=" + bm + "]";
	}
	
}
