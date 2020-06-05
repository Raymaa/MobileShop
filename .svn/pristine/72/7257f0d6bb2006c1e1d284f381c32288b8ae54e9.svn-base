package com.huatec.edu.mobileshop.dao;

import java.util.List;
import java.util.Map;

import com.huatec.edu.mobileshop.entity.Tag;
import com.huatec.edu.mobileshop.entity.brief.BriefTag;
import com.huatec.edu.mobileshop.util.Page;

public interface TagDao {
	public int save(Tag tag);
	public int deleteById(int tag_id);
	public List<Tag> findAll();
	public Tag findById(int tag_id);
	public int dynamicUpdate(Tag tag);
	public Tag findByName(String name);
	public List<Tag> findAllByPage(Page page);
	public List<Tag> findByType(int type);
	public List<Tag> findByTypeAndTeam(Map map);
	public List<BriefTag> findUnionByGoodsTagId(int tag_id);
	public List<BriefTag> findUnionByBrandTagId(int tag_id);
}
