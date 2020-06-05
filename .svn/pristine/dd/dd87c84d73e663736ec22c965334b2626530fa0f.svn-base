package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.TagService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/tag")
public class TagController {
	@Resource
	private TagService tagService;
	
	//新增标签
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增标签")
	public Result add(@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="类型")@RequestParam("type") int type,
			@ApiParam(value="商品数量")@RequestParam("count") int count,
			@ApiParam(value="分组")@RequestParam("team") int team){
		Result result=tagService.addTag(name, type, count, team);
		return result;
	}
	//加载所有标签（分页）
	@RequestMapping(value="/page/{pageId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有标签（分页）")
	public Result loadAllByPage(@PathVariable("pageId") int pageId){
		Result result=tagService.loadAllTagsByPage(pageId);
		return result;
	}
	//加载所有商品标签
	@RequestMapping(value="/goods",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有商品标签")
	public Result loadAllGoodsTag(){
		Result result=tagService.loadAllGoodsTag();
		return result;
	}
	//加载所有品牌标签
	@RequestMapping(value="/brand",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有品牌标签")
	public Result loadAllBrandTag(){
		Result result=tagService.loadAllBrandTag();
		return result;
	}
	//根据分组加载标签下的商品
	@RequestMapping(value="/goods/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据分组加载标签下的商品")
	public Result loadAllGoodsByTeam(@PathVariable("teamId") int teamId){
		Result result=tagService.loadAllGoodsByTeam(teamId);
		return result;
	}
	//根据分组加载标签下的品牌
	@RequestMapping(value="/brand/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据分组加载标签下的品牌")
	public Result loadAllBrandByTeam(@PathVariable("teamId") int teamId){
		Result result=tagService.loadAllBrandByTeam(teamId);
		return result;
	}
	//根据id加载
	@RequestMapping(value="/{tagId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载标签信息")
	public Result loadById(@PathVariable("tagId") int tagId){
		Result result=tagService.loadTagById(tagId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{tagId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新标签信息")
	public Result updateById(@ApiParam(value="标签编号")@PathVariable("tagId") int tagId,
			@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="类型")@RequestParam("type") int type,
			@ApiParam(value="商品数量")@RequestParam("count") int count,
			@ApiParam(value="排序")@RequestParam("sort") int sort,
			@ApiParam(value="分组")@RequestParam("team") int team){
		Result result=tagService.updateTag(tagId, name, type, count, sort, team);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{tagId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除标签信息")
	public Result deleteById(@PathVariable("tagId") int tagId){
		Result result=tagService.deleteTagById(tagId);
		return result;
	}

}
