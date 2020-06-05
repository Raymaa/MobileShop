package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;

import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.entity.brief.BriefGoodsForOrder;

public class OrderGoods implements Serializable {
	private Integer id;
	private Integer order_id;
	private Integer goods_id;
	private Integer goods_num;
	private Double price;
	
	//关联属性
	private BriefGoodsForOrder bgfos;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public BriefGoodsForOrder getBgfos() {
		return bgfos;
	}
	public void setBgfos(BriefGoodsForOrder bgfos) {
		this.bgfos = bgfos;
	}
	public String toString() {
		return "OrderGoods [id=" + id + ", order_id=" + order_id + ", goods_id=" + goods_id + ", goods_num=" + goods_num
				+ ", price=" + price + ", bgfos=" + bgfos + "]";
	}
}
