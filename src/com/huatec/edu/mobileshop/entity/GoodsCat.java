package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefGoodsType;
//商品分类
public class GoodsCat implements Serializable {
	private Integer cat_id;//分类编号
	private String name;//名称
	private Integer parent_id;//父分类id，没有父分类为0
	private String cat_path;//显示路径,0，1，5，20
	private Integer goods_count;//商品数量
	private Integer sort;//显示次序,0：不排序
	private Integer type_id;//类型id
	private Integer list_show;//是否显示到列表，0：显示，1：不显示
	private String image;//图片
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间
	
	//关联属性
	private BriefGoodsType briefGoodsType;
	
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
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getCat_path() {
		return cat_path;
	}
	public void setCat_path(String cat_path) {
		this.cat_path = cat_path;
	}
	public Integer getGoods_count() {
		return goods_count;
	}
	public void setGoods_count(Integer goods_count) {
		this.goods_count = goods_count;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public Integer getList_show() {
		return list_show;
	}
	public void setList_show(Integer list_show) {
		this.list_show = list_show;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	
	public BriefGoodsType getBriefGoodsType() {
		return briefGoodsType;
	}
	public void setBriefGoodsType(BriefGoodsType briefGoodsType) {
		this.briefGoodsType = briefGoodsType;
	}
	public String toString() {
		return "GoodsCat [cat_id=" + cat_id + ", name=" + name + ", parent_id=" + parent_id + ", cat_path=" + cat_path
				+ ", goods_count=" + goods_count + ", sort=" + sort + ", type_id=" + type_id + ", list_show="
				+ list_show + ", image=" + image + ", creatime=" + creatime + ", modifytime=" + modifytime
				+ ", briefGoodsType=" + briefGoodsType + "]";
	}
}
