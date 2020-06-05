package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.TagBrandService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/tag_brand")
public class TagBrandController {
	@Resource
	private TagBrandService tagBrandService;
	
	//新增标签品牌关联信息
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(int tagId,int brandId){
		Result result=tagBrandService.add(tagId, brandId);
		return result;
	}
	//根据标签id加载品牌
	@RequestMapping(value="/tag/{tagId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByTagId(@PathVariable("tagId") int tagId){
		Result result=tagBrandService.loadByTagId(tagId);
		return result;		
	}
	//根据id更新sort
	@RequestMapping(value="/sort/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateSortById(@PathVariable("id") int id,int sort){
		Result result=tagBrandService.updateSortById(id, sort);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("id") int id){
		Result result=tagBrandService.deleteById(id);
		return result;
	}
}
