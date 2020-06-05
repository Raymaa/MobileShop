package com.huatec.edu.mobileshop.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	//新增商品
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name,String sn,String brief,String description,
			double price,double cost,double mktprice,int catId,int brandId,
			double weight,String intro){
		Result result=goodsService.addGoods(name, sn, brief, description, 
				price, cost, mktprice, catId, brandId, weight, intro);
		return result;
	}
	//加载所有商品（关联查询+分页）
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=goodsService.loadAllGoodsByPage(pageId);
		return result;
	}
	//加载所有可用商品（分页）
	@RequestMapping(value="/enable/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadAllEnableByPage(@PathVariable("pageId") int pageId){
		Result result=goodsService.loadAllEnableGoodsByPage(pageId);
		return result;
	}
	//根据id加载商品
	@RequestMapping(value="/{goodsId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadById(@PathVariable("goodsId") int goodsId){
		Result result=goodsService.loadGoodsById(goodsId);
		return result;
	}
	//根据id加载商品(关联查询)
	@RequestMapping(value="/union/{goodsId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByIdUnion(@PathVariable("goodsId") int goodsId){
		Result result=goodsService.loadGoodsByIdUnion(goodsId);
		return result;
	}
	//根据分类id加载商品（已上架的）
	@RequestMapping(value="/cat/{catId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByCatId(@PathVariable("catId") int catId){
		Result result=goodsService.loadGoodsByCatId(catId);
		return result;
	}
	//根据品牌id加载商品（已上架的）
	@RequestMapping(value="/brand/{brandId}",method=RequestMethod.GET)
	@ResponseBody
	public Result loadByBrandId(@PathVariable("brandId") int brandId){
		Result result=goodsService.loadGoodsByBrandId(brandId);
		return result;
	}
	//根据分类名称或品牌名称或商品关键字查询
	@RequestMapping(value="/find",method=RequestMethod.POST)
	@ResponseBody
	public Result search(String input){
		Result result=goodsService.searchGoods(input);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{goodsId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result update(@PathVariable("goodsId") int goodsId,String name,String sn,
			String brief,String description,double price,double cost,double mktprice,
			int mktEnable,int catId,int brandId,double weight,String intro,
			String params,String original){
		Result result=goodsService.updateGoods(goodsId, name, sn, brief, description, 
				price, cost, mktprice, mktEnable, catId, brandId, weight, intro, 
				params, original);
		return result;
	}
	//根据id更新mkt_enable
	@RequestMapping(value="/enable/{goodsId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateEnable(@PathVariable("goodsId") int goodsId,int mktEnable){
		Result result=goodsService.updateEnable(goodsId, mktEnable);
		return result;
	}
	//根据id更新params
	@RequestMapping(value="/params/{goodsId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateParams(int goodsId,String param1,String param2,
			String param3,String param4,String param5){
		String[] paramsValue=new String[]{param1,param2,param3,param4,param5};
		Result result=goodsService.updateParams(goodsId, paramsValue);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{goodsId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("goodsId") int goodsId){
		Result result=goodsService.deleteGoodsById(goodsId);
		return result;
	}
}
