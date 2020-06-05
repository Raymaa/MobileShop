package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.brief.BriefGoods;
import com.huatec.edu.mobileshop.util.Page;

public interface GoodsDao {
	public int save(Goods goods);
	public int deleteById(int goods_id);
	public List<Goods> findAll();
	public Goods findById(int goods_id);
	public int dynamicUpdate(Goods goods);
	public BriefGoods findByName(String name);
	public List<BriefGoods> findUnionByPage(Page page);
	public List<BriefGoods> dynamicFind(Map map);
	public Goods findUnionById(int goods_id);
	public List<BriefGoods> findAllEnableByPage(Page page);
}
