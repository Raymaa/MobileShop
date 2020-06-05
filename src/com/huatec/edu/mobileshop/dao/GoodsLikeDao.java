package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.GoodsLike;

public interface GoodsLikeDao {
	public int save(GoodsLike goodsLike);
	public int deleteById(int like_id);
	public List<GoodsLike> findAll();
	public GoodsLike findById(int like_id);
	public int dynamicUpdate(GoodsLike goodsLike);
	public GoodsLike findRepeat(Map map);
	public List<GoodsLike> findUnionByMemberId(int member_id);
}
