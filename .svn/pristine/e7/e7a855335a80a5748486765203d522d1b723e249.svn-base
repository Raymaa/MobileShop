package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefBrand;
import com.huatec.edu.mobileshop.entity.brief.BriefGoodsType;

//类型品牌对照
public class TypeBrand implements Serializable {
	private Integer id;//编号
	private Integer type_id;//类型编号
	private Integer brand_id;//品牌编号
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间
	//关联属性
	private BriefBrand briefBrand;
	private BriefGoodsType briefGoodsType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
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
	//get、set方法
	public BriefBrand getBriefBrand() {
		return briefBrand;
	}
	public void setBriefBrand(BriefBrand briefBrand) {
		this.briefBrand = briefBrand;
	}
	public BriefGoodsType getBriefGoodsType() {
		return briefGoodsType;
	}
	public void setBriefGoodsType(BriefGoodsType briefGoodsType) {
		this.briefGoodsType = briefGoodsType;
	}
	public String toString() {
		return "TypeBrand [id=" + id + ", type_id=" + type_id + ", brand_id=" + brand_id + ", creatime=" + creatime
				+ ", modifytime=" + modifytime + ", briefBrand=" + briefBrand + ", briefGoodsType=" + briefGoodsType
				+ "]";
	}
}
