package com.huatec.edu.mobileshop.controller.backbone;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.GoodsTypeService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/type")
public class GoodsTypeController2 {
	@Resource
	private GoodsTypeService goodsTypeService;
	//新增商品类型
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增商品类型")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String param1=(String) jmap.get("param1");
        String param2=(String) jmap.get("param2");
        String param3=(String) jmap.get("param3");
        String param4=(String) jmap.get("param4");
        String param5=(String) jmap.get("param5");
        String name=(String) jmap.get("name");
        int isPhysical=Integer.parseInt((String) jmap.get("isPhysical"));
		String[] paramsKey=new String[]{param1,param2,param3,param4,param5};
		Result result=goodsTypeService.addType(name, paramsKey, isPhysical);
		return result;
	}
	//加载所有商品类型
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有商品类型")
	public Result loadAll(){
		Result result=goodsTypeService.loadAllTypes();
		return result;
	}
	//根据id加载商品类型
	@RequestMapping(value="/{typeId}",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载商品类型信息")
	public Result loadById(@PathVariable("typeId") int typeId){
		Result result=goodsTypeService.loadTypeById(typeId);
		return result;
	}
	//根据id更新
	@RequestMapping(value="/{typeId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品类型信息")
	public Result updateById(@ApiParam(value="类型编号")@PathVariable("typeId") int typeId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String param1=(String) jmap.get("param1");
        String param2=(String) jmap.get("param2");
        String param3=(String) jmap.get("param3");
        String param4=(String) jmap.get("param4");
        String param5=(String) jmap.get("param5");
        String name=(String) jmap.get("name");
        int isPhysical=Integer.parseInt((String) jmap.get("isPhysical"));
		String[] paramsKey=new String[]{param1,param2,param3,param4,param5};
		Result result=goodsTypeService.updateType(typeId, name, paramsKey, isPhysical);
		return result;
	}
	//根据id删除
	@RequestMapping(value="/{typeId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除商品类型")
	public Result deleteById(@PathVariable("typeId") int typeId){
		Result result=goodsTypeService.deleteTypeById(typeId);
		return result;
	}
	//根据id更新是否可用
	@RequestMapping(value="/disabled/{typeId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新商品类型状态")
	public Result updateDisabled(@ApiParam(value="类型编号")@PathVariable("typeId") int typeId,
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		int disabled=Integer.parseInt((String) jmap.get("disabled"));
		Result result=goodsTypeService.updateDisabled(typeId, disabled);
		return result;
	}
	//加载所有可用的类型
	@RequestMapping(value="/disabled",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有可用的类型")
	public Result loadByDisabled(){
		Result result=goodsTypeService.loadTypeByDisabled();
		return result;
	}
}
