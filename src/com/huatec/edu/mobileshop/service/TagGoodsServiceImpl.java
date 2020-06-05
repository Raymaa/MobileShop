package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.TagDao;
import com.huatec.edu.mobileshop.dao.TagGoodsDao;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.TagGoods;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class TagGoodsServiceImpl implements TagGoodsService {
	@Resource
	private TagGoodsDao tagGoodsDao;
	@Resource
	private TagDao tagDao;
	@Resource
	private GoodsDao goodsDao;

	//新增标签商品关联信息
	public Result add(int tagId, int goodsId) {
		Result result=new Result();
		Tag tag=tagDao.findById(tagId);
		//判断标签是否存在
		if(tag==null){
			result.setStatus(1);
			result.setMsg("此标签不存在");
			return result;
		}
		//判断是否为商品标签
		if(tag.getType()!=0){
			result.setStatus(1);
			result.setMsg("此标签不是商品标签");
			return result;
		}
		List<TagGoods> tgs=tagGoodsDao.findUnionByTagId(tagId);
		//判断标签下的商品数量
		if(tgs.size()>=tag.getCount()){
			result.setStatus(1);
			result.setMsg("此标签下商品数量已满");
			return result;
		}
		Goods goods=goodsDao.findById(goodsId);
		//判断商品是否存在
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		//判断商品是否上架
		if(goods.getMkt_enable()!=0){
			result.setStatus(1);
			result.setMsg("此商品未上架");
			return result;
		}
		//判断是否已经关联过
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag_id", tagId);
		map.put("goods_id", goodsId);
		TagGoods checkTG=tagGoodsDao.findRepeat(map);
		if(checkTG!=null){
			result.setStatus(1);
			result.setMsg("此标签已经关联过此商品");
			return result;
		}
		TagGoods tagGoods=new TagGoods();
		tagGoods.setId(null);
		tagGoods.setTag_id(tagId);
		tagGoods.setGoods_id(goodsId);
		tagGoods.setSort(0);//默认无排序
		tagGoods.setCreatime(null);
		tagGoods.setModifytime(null);
		tagGoodsDao.save(tagGoods);
		result.setStatus(0);
		result.setMsg("添加标签商品关联信息成功");
		result.setData(tagGoods);
		return result;
	}

	//根据标签id加载商品
	public Result loadByTagId(int tagId) {
		Result result=new Result();
		Tag tag=tagDao.findById(tagId);
		//判断标签是否存在
		if(tag==null){
			result.setStatus(1);
			result.setMsg("此标签不存在");
			return result;
		}
		//判断是否为商品标签
		if(tag.getType()!=0){
			result.setStatus(1);
			result.setMsg("此标签不是商品标签");
			return result;
		}
		List<TagGoods> tgs=tagGoodsDao.findUnionByTagId(tagId);
		if(tgs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此标签下没有商品");
			result.setData(tgs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载标签下的商品成功");
		result.setData(tgs);
		return result;
	}
	
	//根据id更新排序（sort）
	public Result updateSortById(int id, int sort) {
		Result result=new Result();
		TagGoods checkTG=tagGoodsDao.findById(id);
		if(checkTG==null){
			result.setStatus(1);
			result.setMsg("此标签商品关联信息不存在");
			return result;
		}
		TagGoods tagGoods=new TagGoods();
		tagGoods.setId(id);
		tagGoods.setSort(sort);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tagGoods.setModifytime(now);
		tagGoodsDao.dynamicUpdate(tagGoods);
		result.setStatus(0);
		result.setMsg("更新排序成功");
		return result;
	}
	
	//根据id删除
	public Result deleteById(int id) {
		Result result=new Result();
		TagGoods tagGoods=tagGoodsDao.findById(id);
		if(tagGoods==null){
			result.setStatus(1);
			result.setMsg("此标签商品关联信息不存在");
			return result;
		}
		tagGoodsDao.deleteById(id);
		result.setStatus(0);
		result.setMsg("删除标签商品关联信息成功");
		return result;
	}

}
