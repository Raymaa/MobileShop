package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.entity.brief.BriefTag;
//标签商品引用
public class TagGoods implements Serializable {
	private Integer id;//编号
	private Integer tag_id;//标签编号
	private Integer goods_id;//商品编号
	private Integer sort;//排序
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间
	//关联属性
	private BriefGoods briefGoods;
	private BriefTag briefTag;
	
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
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
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
	
	public BriefGoods getBriefGoods() {
		return briefGoods;
	}
	public void setBriefGoods(BriefGoods briefGoods) {
		this.briefGoods = briefGoods;
	}
	
	public String toString() {
		return "TagGoods [id=" + id + ", tag_id=" + tag_id + ", goods_id=" + goods_id + ", sort=" + sort + ", creatime="
				+ creatime + ", modifytime=" + modifytime + ", briefGoods=" + briefGoods + ", briefTag=" + briefTag
				+ "]";
	}
	
}
