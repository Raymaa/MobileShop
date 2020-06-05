package com.huatec.edu.mobileshop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huatec.edu.mobileshop.service.RoleService;
import com.huatec.edu.mobileshop.util.Result;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Result add(String name,String description){
		Result result=roleService.addRole(name, description);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Result loadAll(){
		Result result=roleService.loadAllRole();
		return result;
	}
	
	@RequestMapping(value="/{roleId}",method=RequestMethod.PUT)
	@ResponseBody
	public Result updateById(@PathVariable("roleId") int roleId,String name,String description){
		Result result=roleService.updateRole(roleId, name, description);
		return result;
	}
	
	@RequestMapping(value="/{roleId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Result deleteById(@PathVariable("roleId") int roleId){
		Result result=roleService.deleteRoleById(roleId);
		return result;
	}
}
