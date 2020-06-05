package com.huatec.edu.mobileshop.controller.backbone;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.TagBrandService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/tag_brand")
public class TagBrandController2 {
	@Resource
	private TagBrandService tagBrandService;
	
	//新增标签品牌关联信息
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增标签品牌关联信息")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int tagId=Integer.parseInt((String) jmap.get("tagId"));
	    int brandId=Integer.parseInt((String) jmap.get("brandId"));
		Result result=tagBrandService.add(tagId, brandId);
		return result;
	}
	//根据标签id加载品牌
	@RequestMapping(value="/tag/{tagId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据标签编号加载品牌")
	public Result loadByTagId(@PathVariable("tagId") int tagId){
		Result result=tagBrandService.loadByTagId(tagId);
		return result;		
	}
	//根据id更新sort
	@RequestMapping(value="/sort/{id}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新sort")
	public Result updateSortById(@ApiParam(value="编号")@PathVariable("id") int id,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int sort=Integer.parseInt((String) jmap.get("sort"));
		Result result=tagBrandService.updateSortById(id, sort);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除标签品牌关联信息")
	public Result deleteById(@PathVariable("id") int id){
		Result result=tagBrandService.deleteById(id);
		return result;
	}
}
