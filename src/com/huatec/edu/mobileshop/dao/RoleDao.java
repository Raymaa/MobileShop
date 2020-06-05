package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Role;

public interface RoleDao {
	public int save(Role role);
	public List<Role> findAll();
	public int deleteById(int role_id);
	public Role findById(int role_id);
	public int dynamicUpdate(Role role);
	public Role findByName(String name);
}
