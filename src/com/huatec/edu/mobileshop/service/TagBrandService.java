package com.huatec.edu.mobileshop.service;

import com.huatec.edu.mobileshop.util.Result;

public interface TagBrandService {
	//新增标签品牌关联信息
	public Result add(int tagId,int brandId);
	//根据标签id加载品牌
	public Result loadByTagId(int tagId);
	//根据id更新sort
	public Result updateSortById(int id,int sort);
	//根据id删除
	public Result deleteById(int id);
}
