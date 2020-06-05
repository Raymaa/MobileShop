package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.TagDao;
import com.huatec.edu.mobileshop.dao.TagGoodsDao;
import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.TagGoods;
import com.huatec.edu.mobileshop.entity.brief.BriefTag;
import com.huatec.edu.mobileshop.util.Page;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class TagServiceImpl implements TagService {
	@Resource
	private TagDao tagDao;

	//新增标签
	public Result addTag(String name, int type, int count, int team) {
		Result result=new Result();
		Tag checkTag=tagDao.findByName(name);
		if(checkTag!=null){
			result.setStatus(1);
			result.setMsg("已经存在此标签");
			return result;
		}
		Tag tag=new Tag();
		tag.setTag_id(null);
		tag.setName(name);
		tag.setType(type);//0:商品标签，1：品牌标签
		tag.setCount(count);
		tag.setSort(0);//默认没有排序
		//0:推荐区，1：1楼广告区，2：2楼广告区 ......
		tag.setTeam(team);
		tag.setCreatime(null);
		tag.setModifytime(null);
		tagDao.save(tag);
		result.setStatus(0);
		result.setMsg("新增标签成功");
		result.setData(tag);
		return result;
	}

	//加载所有标签（分页）
	public Result loadAllTagsByPage(int current) {
		Result result=new Result();
		Page page=new Page();
		page.setCurrent(current);
		page.setPageSize(10);
		List<Tag> tags=tagDao.findAllByPage(page);
		if(tags.isEmpty()){
			result.setStatus(1);
			result.setMsg("此页没有标签");
			result.setData(tags);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询标签成功");
		result.setData(tags);
		return result;
	}

	//加载所有商品标签
	public Result loadAllGoodsTag() {
		Result result=new Result();
		List<Tag> tags=tagDao.findByType(0);
		if(tags.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有商品标签");
			result.setData(tags);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载商品标签成功");
		result.setData(tags);
		return result;
	}

	//加载所有品牌标签
	public Result loadAllBrandTag() {
		Result result=new Result();
		List<Tag> tags=tagDao.findByType(1);
		if(tags.isEmpty()){
			result.setStatus(1);
			result.setMsg("没有品牌标签");
			result.setData(tags);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载品牌标签成功");
		result.setData(tags);
		return result;
	}

	//根据分组加载标签下的商品
	public Result loadAllGoodsByTeam(int team) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("type", 0);
		map.put("team", team);
		List<Tag> tags=tagDao.findByTypeAndTeam(map);
		if(tags.isEmpty()){
			result.setStatus(1);
			result.setMsg("此分组下没有商品标签");
			return result;
		}
		List<BriefTag> allBTS=new ArrayList<BriefTag>();
		for(Tag tag:tags){
			//标签商品引用表、商品表、标签表三表关联查询
			List<BriefTag> bts=tagDao.findUnionByGoodsTagId(tag.getTag_id());
			allBTS.addAll(bts);
		}
		if(allBTS.isEmpty()){
			result.setStatus(1);
			result.setMsg("此组标签下没有商品");
			result.setData(allBTS);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载标签下的商品成功");
		result.setData(allBTS);
		return result;
	}

	//根据分组加载标签下的品牌
	public Result loadAllBrandByTeam(int team) {
		Result result=new Result();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("type", 1);
		map.put("team", team);
		List<Tag> tags=tagDao.findByTypeAndTeam(map);
		if(tags.isEmpty()){
			result.setStatus(1);
			result.setMsg("此分组下没有品牌标签");
			return result;
		}
		List<BriefTag> allBTS=new ArrayList<BriefTag>();
		for(Tag tag:tags){
			//标签表、标签品牌引用表、品牌表三表关联查询
			List<BriefTag> bts=tagDao.findUnionByBrandTagId(tag.getTag_id());
			allBTS.addAll(bts);
		}
		if(allBTS.isEmpty()){
			result.setStatus(1);
			result.setMsg("此组标签下没有品牌");
			result.setData(allBTS);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载标签下的品牌成功");
		result.setData(allBTS);
		return result;
	}

	//根据id加载
	public Result loadTagById(int tagId) {
		Result result=new Result();
		Tag tag=tagDao.findById(tagId);
		if(tag==null){
			result.setStatus(1);
			result.setMsg("不存在此标签");
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载标签信息成功");
		result.setData(tag);
		return result;
	}

	//根据id更新
	public Result updateTag(int tagId, String name, int type, int count, int sort, int team) {
		Result result=new Result();
		Tag checkTag=tagDao.findByName(name);
		if(checkTag!=null){
			result.setStatus(1);
			result.setMsg("此标签已经存在");
			return result;
		}
		Tag tag=new Tag();
		tag.setTag_id(tagId);
		tag.setName(name);
		tag.setType(type);
		tag.setCount(count);
		tag.setSort(sort);
		tag.setTeam(team);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tag.setModifytime(now);
		tagDao.dynamicUpdate(tag);
		result.setStatus(0);
		result.setMsg("更新标签成功");
		return result;
	}

	//根据id删除
	public Result deleteTagById(int tagId) {
		Result result=new Result();
		Tag checkTag=tagDao.findById(tagId);
		if(checkTag==null){
			result.setStatus(1);
			result.setMsg("不存在此标签");
			return result;
		}
		tagDao.deleteById(tagId);
		result.setStatus(0);
		result.setMsg("删除标签成功");
		return result;
	}

}
