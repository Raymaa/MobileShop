package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefBrand;
//标签品牌引用
public class TagBrand implements Serializable {
	private Integer id;//编号
	private Integer tag_id;//标签编号
	private Integer brand_id;//商品编号
	private Integer sort;//排序
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间 
	
	//关联属性
	private BriefBrand briefBrand;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
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
	
	public BriefBrand getBriefBrand() {
		return briefBrand;
	}
	public void setBriefBrand(BriefBrand briefBrand) {
		this.briefBrand = briefBrand;
	}
	public String toString() {
		return "TagBrand [id=" + id + ", tag_id=" + tag_id + ", brand_id=" + brand_id + ", sort=" + sort + ", creatime="
				+ creatime + ", modifytime=" + modifytime + ", briefBrand=" + briefBrand + "]";
	}
	
}
