package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.RoleService;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增角色")
	public Result add(@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="描述")@RequestParam("description") String description){
		Result result=roleService.addRole(name, description);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="加载所有角色")
	public Result loadAll(){
		Result result=roleService.loadAllRole();
		return result;
	}
	
	@RequestMapping(value="/{roleId}",method=RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value="更新角色信息")
	public Result updateById(@ApiParam(value="角色编号")@PathVariable("roleId") int roleId,
			@ApiParam(value="名称")@RequestParam("name") String name,
			@ApiParam(value="描述")@RequestParam("description") String description){
		Result result=roleService.updateRole(roleId, name, description);
		return result;
	}
	
	@RequestMapping(value="/{roleId}",method=RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value="删除角色信息")
	public Result deleteById(@PathVariable("roleId") int roleId){
		Result result=roleService.deleteRoleById(roleId);
		return result;
	}
}
