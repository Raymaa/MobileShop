package com.huatec.edu.mobileshop.dao;

import java.util.List;
import com.huatec.edu.mobileshop.entity.GoodsComment;

public interface GoodsCommentDao {
	public int save(GoodsComment goodsComment);
	public List<GoodsComment> findAll();
	public int deleteById(int comment_id);
	public GoodsComment findById(int comment_id);
	public int dynamicUpdate(GoodsComment goodsComment);
	public List<GoodsComment> findUnionByGoodsId(int goods_id);
	public List<GoodsComment> findUnionByMemberId(int member_id);
}
