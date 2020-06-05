package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface GoodsCommentService {
	public Result addComment(int orderId,int goodsId,int score,String content,int isopen);
	public Result loadCommentByGoodsId(int goodsId);
	public Result loadCommentByMemberId(int memberId);
}
