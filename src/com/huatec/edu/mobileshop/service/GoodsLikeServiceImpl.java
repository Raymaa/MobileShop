package com.huatec.edu.mobileshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huatec.edu.mobileshop.dao.GoodsDao;
import com.huatec.edu.mobileshop.dao.GoodsLikeDao;
import com.huatec.edu.mobileshop.dao.MemberDao;
import com.huatec.edu.mobileshop.entity.Goods;
import com.huatec.edu.mobileshop.entity.GoodsLike;
import com.huatec.edu.mobileshop.entity.Member;
import com.huatec.edu.mobileshop.util.Result;
@Service
public class GoodsLikeServiceImpl implements GoodsLikeService {
	@Resource
	private GoodsLikeDao goodsLikeDao;
	@Resource
	private GoodsDao goodsDao;
	@Resource
	private MemberDao memberDao;
	
	//新增商品收藏信息
	public Result add(int goodsId, int memberId) {
		Result result=new Result();
		Goods goods=goodsDao.findById(goodsId);
		if(goods==null){
			result.setStatus(1);
			result.setMsg("不存在此商品");
			return result;
		}
		if(goods.getMkt_enable()!=0){
			result.setStatus(1);
			result.setMsg("商品已下架");
			return result;
		}
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("goods_id", goodsId);
		map.put("member_id", memberId);
		GoodsLike checkGL=goodsLikeDao.findRepeat(map);
		if(checkGL!=null){
			result.setStatus(1);
			result.setMsg("此会员已经收藏过此商品");
			return result;
		}
		GoodsLike goodsLike=new GoodsLike();
		goodsLike.setLike_id(null);
		goodsLike.setGoods_id(goodsId);
		goodsLike.setMember_id(memberId);
		goodsLike.setCreatime(null);
		goodsLike.setModifytime(null);
		goodsLikeDao.save(goodsLike);
		result.setStatus(0);
		result.setMsg("收藏商品成功");
		return result;
	}

	//根据会员id加载收藏的商品
	public Result loadByMemberId(int memberId) {
		Result result=new Result();
		Member member=memberDao.findById(memberId);
		if(member==null){
			result.setStatus(1);
			result.setMsg("不存在此会员");
			return result;
		}
		List<GoodsLike> gls=goodsLikeDao.findUnionByMemberId(memberId);
		if(gls.isEmpty()){
			result.setStatus(1);
			result.setMsg("此会员没有收藏商品");
			result.setData(gls);
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询收藏的商品成功");
		result.setData(gls);
		return result;
	}

	//根据id删除
	public Result deleteById(int likeId) {
		Result result=new Result();
		GoodsLike checkGL=goodsLikeDao.findById(likeId);
		if(checkGL==null){
			result.setStatus(1);
			result.setMsg("不存在此收藏");
			return result;
		}
		goodsLikeDao.deleteById(likeId);
		result.setStatus(0);
		result.setMsg("删除收藏商品信息成功");
		return result;
	}

}
