package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.TagBrand;

public interface TagBrandDao {
	public int save(TagBrand tagBrand);
	public int deleteById(int id);
	public List<TagBrand> findAll();
	public TagBrand findById(int id);
	public int dynamicUpdate(TagBrand tagBrand);
	public List<TagBrand> findUnionByTagId(int tag_id);
	public TagBrand findRepeat(Map map);
}
