package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.TypeBrandService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/type_brand")
public class TypeBrandController {
	@Resource
	private TypeBrandService typeBrandService;
	//新增
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(int typeId,int brandId){
		Result result=typeBrandService.add(typeId, brandId);
		return result;
	}
	//加载所有（关联查询）
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadAll(){
		Result result=typeBrandService.loadAll();
		return result;
	}
	//根据id加载（关联查询）
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("id") int id){
		Result result=typeBrandService.loadById(id);
		return result;
	}
	//根据类型id加载（关联查询）
	@RequestMapping(value="/type/{typeId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByTypeId(@PathVariable("typeId") int typeId){
		Result result=typeBrandService.loadByTypeId(typeId);
		return result;
	}
	//根据品牌id加载（关联查询）
	@RequestMapping(value="/brand/{brandId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByBrandId(@PathVariable("brandId") int brandId){
		Result result=typeBrandService.loadByBrandId(brandId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("id") int id,int typeId,int brandId){
		Result result=typeBrandService.update(id, typeId, brandId);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("id") int id){
		Result result=typeBrandService.deleteById(id);
		return result;
	}
}
