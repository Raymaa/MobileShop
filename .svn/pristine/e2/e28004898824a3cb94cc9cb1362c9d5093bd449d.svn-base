package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.BrandService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/brand")
public class BrandController {
	@Resource
	private BrandService brandService;
	//新增品牌
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name, String logo, String keywords, 
			String description, String url){
		Result result=brandService.addBrand(name, logo, keywords, description, url);
		return result;
	}
	//加载所有品牌(分页)
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=brandService.loadAllBrandsByPage(pageId);
		return result;
	}
	//根据id加载品牌
	@RequestMapping(value="/{brandId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("brandId") int brandId){
		Result result=brandService.loadBrandById(brandId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{brandId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("brandId") int brandId,String name,
			String logo,String keywords,String description,String url){
		Result result=brandService.updateBrand(brandId, name, logo, keywords, 
				description, url);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{brandId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("brandId") int brandId){
		Result result=brandService.deleteBrandById(brandId);
		return result;
	}
	//根据id更新是否可用
	@RequestMapping(value="/disabled/{brandId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateDisabled(@PathVariable("brandId") int brandId,int disabled){
		Result result=brandService.updateDisabled(brandId, disabled);
		return result;
	}
	//加载所有可用的品牌
	@RequestMapping(value="/disabled",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByDisabled(){
		Result result=brandService.loadBrandByDisabled();
		return result;
	}
}
