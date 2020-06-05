package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;
//简单的品牌实体类，用于查询
public class BriefBrand implements Serializable {
	private Integer brand_id;//品牌编号
	private String name;//名称
	private String logo;//logo
	
	//如果增加有参构造，默认就不再有无参构造，所以需要同时添加无参构造
	public BriefBrand() {
		super();
	}
	public BriefBrand(String name, String logo) {
		super();
		this.name = name;
		this.logo = logo;
	}

	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	//toString方法
	public String toString() {
		return "BriefBrand [brand_id=" + brand_id + ", name=" + name + ", logo=" + logo + "]";
	}
	
	
}
