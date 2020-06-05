package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.GoodsType;

public interface GoodsTypeDao {
	public int save(GoodsType goodsType);
	public int deleteById(int type_id);
	public List<GoodsType> findAll();
	public GoodsType findById(int type_id);
	public int dynamicUpdate(GoodsType goodsType);
	public GoodsType findByName(String name);
	public List<GoodsType> findByDisabled(int disabled);
}
