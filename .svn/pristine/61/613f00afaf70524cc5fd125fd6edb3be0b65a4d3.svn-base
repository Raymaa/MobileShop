package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tag implements Serializable {
	private Integer tag_id;//标签编号
	private String name;//标签名称
	private Integer type;//标签类型，0：商品标签，1：品牌标签
	private Integer count;//标签下商品/品牌的数量
	private Integer sort;//排序，可改变标签在分组中的显示位置,默认为0
	private Integer team;//分组，决定标签在首页的显示位置
	private Timestamp creatime;//创建标签的时间
	private Timestamp modifytime;//修改标签的时间
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getTeam() {
		return team;
	}
	public void setTeam(Integer team) {
		this.team = team;
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
		return "Tag [tag_id=" + tag_id + ", name=" + name + ", type=" + type + ", count=" + count + ", sort=" + sort
				+ ", team=" + team + ", creatime=" + creatime + ", modifytime=" + modifytime + "]";
	}
	
}
