package com.huatec.edu.mobileshop.entity.brief;

import java.io.Serializable;
import java.util.List;

import com.huatec.edu.mobileshop.entity.TagBrand;
import com.huatec.edu.mobileshop.entity.TagGoods;

public class BriefTag implements Serializable {
	private Integer tag_id;//标签编号
	private String name;//标签名称
	
	//关联属性
	private List<BriefGoods> bgs;
	private List<BriefBrand> bbs;
	//get、set方法
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<BriefGoods> getBgs() {
		return bgs;
	}
	public void setBgs(List<BriefGoods> bgs) {
		this.bgs = bgs;
	}
	
	public List<BriefBrand> getBbs() {
		return bbs;
	}
	public void setBbs(List<BriefBrand> bbs) {
		this.bbs = bbs;
	}
	//toString方法
	public String toString() {
		return "BriefTag [tag_id=" + tag_id + ", name=" + name + ", bgs=" + bgs + ", bbs=" + bbs + "]";
	}
}
