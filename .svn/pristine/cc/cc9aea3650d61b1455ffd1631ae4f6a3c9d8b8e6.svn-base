package com.huatec.edu.mobileshop.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.BrandDao;
import com.huatec.edu.mobileshop.dao.TagBrandDao;
import com.huatec.edu.mobileshop.dao.TagDao;
import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.TagBrand;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class TagBrandServiceImpl implements TagBrandService {
	@Resource
	private TagBrandDao tagBrandDao;
	@Resource
	private TagDao tagDao;
	@Resource
	private BrandDao brandDao;

	//新增标签品牌关联信息
	public Result add(int tagId, int brandId) {
		Result result=new Result();
		Tag tag=tagDao.findById(tagId);
		//判断标签是否存在
		if(tag==null){
			result.setStatus(1);
			result.setMsg("此标签不存在");
			return result;
		}
		//判断是否为品牌标签
		if(tag.getType()!=1){
			result.setStatus(1);
			result.setMsg("此标签不是品牌标签");
			return result;
		}
		List<TagBrand> tbs=tagBrandDao.findUnionByTagId(tagId);
		//判断标签下的品牌数量
		if(tbs.size()>=tag.getCount()){
			result.setStatus(1);
			result.setMsg("此标签下品牌数量已满");
			return result;
		}
		Brand brand=brandDao.findById(brandId);
		//判断品牌是否存在
		if(brand==null){
			result.setStatus(1);
			result.setMsg("不存在此品牌");
			return result;
		}
		//判断品牌是否可用
		if(brand.getDisabled()!=0){
			result.setStatus(1);
			result.setMsg("此品牌不可用");
			return result;
		}
		//判断是否已经关联过
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tag_id", tagId);
		map.put("brand_id", brandId);
		TagBrand checkTB=tagBrandDao.findRepeat(map);
		if(checkTB!=null){
			result.setStatus(1);
			result.setMsg("此标签已经关联过此品牌");
			return result;
		}
		TagBrand tagBrand=new TagBrand();
		tagBrand.setId(null);
		tagBrand.setTag_id(tagId);
		tagBrand.setBrand_id(brandId);
		tagBrand.setSort(0);//默认为0
		tagBrand.setCreatime(null);
		tagBrand.setModifytime(null);
		tagBrandDao.save(tagBrand);
		result.setStatus(0);
		result.setMsg("添加标签品牌关联信息成功");
		result.setData(tagBrand);
		return result;
	}

	//根据标签id加载品牌
	public Result loadByTagId(int tagId) {
		Result result=new Result();
		Tag tag=tagDao.findById(tagId);
		//判断标签是否存在
		if(tag==null){
			result.setStatus(1);
			result.setMsg("此标签不存在");
			return result;
		}
		//判断是否为品牌标签
		if(tag.getType()!=1){
			result.setStatus(1);
			result.setMsg("此标签不是品牌标签");
			return result;
		}
		List<TagBrand> tbs=tagBrandDao.findUnionByTagId(tagId);
		if(tbs.isEmpty()){
			result.setStatus(1);
			result.setMsg("此标签下没有品牌");
			result.setData(tbs);
			return result;
		}
		result.setStatus(0);
		result.setMsg("加载标签下的品牌成功");
		result.setData(tbs);
		return result;
	}
	
	//根据id更新sort
	public Result updateSortById(int id, int sort) {
		Result result=new Result();
		TagBrand checkTB=tagBrandDao.findById(id);
		if(checkTB==null){
			result.setStatus(1);
			result.setMsg("此标签品牌关联信息不存在");
			return result;
		}
		TagBrand tagBrand=new TagBrand();
		tagBrand.setId(id);
		tagBrand.setSort(sort);
		Timestamp now=new Timestamp(System.currentTimeMillis());
		tagBrand.setModifytime(now);
		tagBrandDao.dynamicUpdate(tagBrand);
		result.setStatus(0);
		result.setMsg("更新排序成功");
		return result;
	}
		
	//根据id删除
	public Result deleteById(int id) {
		Result result=new Result();
		TagBrand checkTB=tagBrandDao.findById(id);
		if(checkTB==null){
			result.setStatus(1);
			result.setMsg("此标签品牌关联信息不存在");
			return result;
		}
		tagBrandDao.deleteById(id);
		result.setStatus(0);
		result.setMsg("删除标签品牌关联信息成功");
		return result;
	}

	

}
