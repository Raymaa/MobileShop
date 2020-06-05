package com.huatec.edu.mobileshop.entity.select;

import java.io.Serializable;
import java.util.List;

import com.huatec.edu.mobileshop.entity.OrderGoods;
import com.huatec.edu.mobileshop.entity.OrderLog;
import com.huatec.edu.mobileshop.entity.brief.BriefOrderLog;

//订单详情时使用
public class OrderResult implements Serializable {
	private Integer order_id;//订单编号
	private String order_sn;//订单号
	private Integer order_status;//订单状态
	private String member_address;//收货人地址信息
	private String ship_name;//货运公司名字
	private String logi_sn;//物流编号
	private Integer logi_status;//物流状态
	private Double carriage;//运费
	private String paytype_name;//支付类型的名称
	private List<OrderGoods> ogs;//商品集合
	private List<BriefOrderLog> bols;//订单日志
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getShip_name() {
		return ship_name;
	}
	public void setShip_name(String ship_name) {
		this.ship_name = ship_name;
	}
	public String getLogi_sn() {
		return logi_sn;
	}
	public void setLogi_sn(String logi_sn) {
		this.logi_sn = logi_sn;
	}
	public Integer getLogi_status() {
		return logi_status;
	}
	public void setLogi_status(Integer logi_status) {
		this.logi_status = logi_status;
	}
	public Double getCarriage() {
		return carriage;
	}
	public void setCarriage(Double carriage) {
		this.carriage = carriage;
	}
	public String getPaytype_name() {
		return paytype_name;
	}
	public void setPaytype_name(String paytype_name) {
		this.paytype_name = paytype_name;
	}
	
	public List<OrderGoods> getOgs() {
		return ogs;
	}
	public void setOgs(List<OrderGoods> ogs) {
		this.ogs = ogs;
	}
	public List<BriefOrderLog> getBols() {
		return bols;
	}
	public void setBols(List<BriefOrderLog> bols) {
		this.bols = bols;
	}
	public String toString() {
		return "OrderResult [order_id=" + order_id + ", order_sn=" + order_sn + ", order_status=" + order_status
				+ ", member_address=" + member_address + ", ship_name=" + ship_name + ", logi_sn=" + logi_sn
				+ ", logi_status=" + logi_status + ", carriage=" + carriage + ", paytype_name=" + paytype_name
				+ ", ogs=" + ogs + ", bols=" + bols + "]";
	}
}
