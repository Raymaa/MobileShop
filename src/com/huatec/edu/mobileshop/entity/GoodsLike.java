package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
//商品收藏
public class GoodsLike implements Serializable {
	private Integer like_id;//收藏编号
	private Integer goods_id;//商品编号
	private Integer member_id;//会员编号
	private Timestamp creatime;//创建时间
	private Timestamp modifytime;//修改时间
	
	//关联属性
	private BriefGoods briefGoods;
	
	public Integer getLike_id() {
		return like_id;
	}
	public void setLike_id(Integer like_id) {
		this.like_id = like_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
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
		return "GoodsLike [like_id=" + like_id + ", goods_id=" + goods_id + ", member_id=" + member_id + ", creatime="
				+ creatime + ", modifytime=" + modifytime + ", briefGoods=" + briefGoods + "]";
	}
	
}
