package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.GoodsCat;

public interface GoodsCatDao {
	public int save(GoodsCat goodsCat);
	public int deleteById(int cat_id);
	public List<GoodsCat> findAll();
	public GoodsCat findById(int cat_id);
	public int dynamicUpdate(GoodsCat goodsCat);
	public List<GoodsCat> findByTypeId(int type_id);
	public GoodsCat findByName(String name);
	public List<GoodsCat> findByCatPathDESC(int length);
	public List<GoodsCat> findByParentIdDESC(int parent_id);
//	public List<GoodsCat> findByCatPath(int length);
//	public List<GoodsCat> findByParentId(int parent_id);
	public List<GoodsCat> dynamicFind(GoodsCat goodsCat);
	public List<GoodsCat> findUnionByParentId(int parent_id);
	public GoodsCat findUnionById(int cat_id);
}
