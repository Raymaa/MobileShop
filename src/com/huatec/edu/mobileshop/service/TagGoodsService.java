package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface TagGoodsService {
	//新增标签商品关联信息
	public Result add(int tagId,int goodsId);
	//根据标签id加载商品
	public Result loadByTagId(int tagId);
	//根据id更新排序（sort）
	public Result updateSortById(int id,int sort);
	//根据id删除
	public Result deleteById(int id);
}
