package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Brand;
import com.huatec.edu.mobileshop.util.Page;

public interface BrandDao {
	public int save(Brand brand);
	public int deleteById(int brand_id);
	public List<Brand> findAll();
	public Brand findById(int brand_id);
	public int dynamicUpdate(Brand brand);
	public Brand findByName(String name);
	public List<Brand> findByDisabled(int disabled);
	public List<Brand> findAllByPage(Page page);
}
