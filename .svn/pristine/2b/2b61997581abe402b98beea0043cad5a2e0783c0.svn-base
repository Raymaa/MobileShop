package com.huatec.edu.mobileshop.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.entity.brief.BriefMember;

public class GoodsComment implements Serializable {
	private Integer comment_id;
	private Integer order_id;
	private Integer goods_id;
	private Integer member_id;
	private Integer score;//分数，5分制
	private String content;//评论
	private Integer isopen;//是否公开，0：公开，1：匿名
	private Timestamp creatime;
	
	//关联属性
	private BriefMember briefMember;
	private BriefGoods briefGoods;
	
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
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
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getIsopen() {
		return isopen;
	}
	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}
	public Timestamp getCreatime() {
		return creatime;
	}
	public void setCreatime(Timestamp creatime) {
		this.creatime = creatime;
	}
	public BriefMember getBriefMember() {
		return briefMember;
	}
	public void setBriefMember(BriefMember briefMember) {
		this.briefMember = briefMember;
	}
	
	public BriefGoods getBriefGoods() {
		return briefGoods;
	}
	public void setBriefGoods(BriefGoods briefGoods) {
		this.briefGoods = briefGoods;
	}
	public String toString() {
		return "GoodsComment [comment_id=" + comment_id + ", order_id=" + order_id + ", goods_id=" + goods_id
				+ ", member_id=" + member_id + ", score=" + score + ", content=" + content + ", isopen=" + isopen
				+ ", creatime=" + creatime + ", briefMember=" + briefMember + ", briefGoods=" + briefGoods + "]";
	}
	
}
