package com.huatec.edu.mobileshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodsCommentDao;
import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.dao.OrderDao;
import com.huatec.edu.mobileshop.dao.OrderGoodsDao;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.GoodsComment;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.entity.Order;
import com.huatec.edu.mobileshop.entity.OrderGoods;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class GoodsCommentServiceImpl implements GoodsCommentService {
	@Resource
	private GoodsCommentDao goodsCommentDao;
	@Resource
	private OrderDao orderDao;
	@Resource
	private OrderGoodsDao OrderGoodsDao;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private MemberDao memberDao;
	
	public Result addComment(int orderId, int goodsId, int score, String content, int isopen) {
		Result result=new Result();
		Order order=orderDao.findById(orderId);
		if(order==null){
			result.setStatus(1);
			result.setMsg("不存在此订单");
			return result;
		}
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("order_id", orderId);
		map.put("goods_id", goodsId);
		OrderGoods og=OrderGoodsDao.findRepeat(map);
		if(og==null){
			result.setStatus(1);
			result.setMsg("此订单不存在该商品");
			return result;
		}
		int memberId=order.getMember_id();
		GoodsComment goodsComment=new GoodsComment();
		goodsComment.setComment_id(null);
		goodsComment.setOrder_id(orderId);
		goodsComment.setGoods_id(goodsId);
		goodsComment.setMember_id(memberId);
		goodsComment.setScore(score);
		goodsComment.setContent(content);
		goodsComment.setIsopen(isopen);
		goodsComment.setCreatime(null);
		goodsCommentDao.save(goodsComment);
		result.setStatus(0);
		result.setMsg("提交评价成功");
		return result;
	}

	public Result loadCommentByGoodsId(int goodsId) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		List<GoodsComment> gcs=goodsCommentDao.findUnionByGoodsId(goodsId);
		result.setStatus(0);
		result.setMsg("加载评论成功");
		result.setData(gcs);
		return result;
	}

	public Result loadCommentByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		List<GoodsComment> gcs=goodsCommentDao.findUnionByMemberId(memberId);
		result.setStatus(0);
		result.setMsg("加载评论成功");
		result.setData(gcs);
		return result;
	}

}
