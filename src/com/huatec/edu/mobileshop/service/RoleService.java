package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface RoleService {
	public Result addRole(String name,String description);
	public Result loadAllRole();
	public Result updateRole(int roleId,String name,String description);
	public Result deleteRoleById(int roleId);
}
