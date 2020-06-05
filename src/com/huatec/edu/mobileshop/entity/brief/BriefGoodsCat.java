package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;

public class BriefGoodsCat implements Serializable {
	private Integer cat_id;//分类编号
	private String name;//名称
	
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "BriefGoodsCat [cat_id=" + cat_id + ", name=" + name + "]";
	}
	
}
