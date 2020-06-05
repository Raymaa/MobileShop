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

import com.huatec.edu.mobileshop.service.RoleService;
import com.huatec.edu.mobileshop.util.MSUtil;
import com.huatec.edu.mobileshop.util.Result;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/backbone/role")
public class RoleController2 {
	@Resource
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value="新增角色")
	public Result add(HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String name=(String) jmap.get("name");
        String description=(String) jmap.get("description");
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
			HttpServletRequest request){
		Map jmap=MSUtil.getParam(request);
		String name=(String) jmap.get("name");
        String description=(String) jmap.get("description");
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
