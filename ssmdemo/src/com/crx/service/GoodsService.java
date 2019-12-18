package com.crx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crx.mapper.GoodsMapper;
import com.crx.pojo.Goods;
import com.crx.pojo.GoodsExample;
import com.crx.pojo.GoodsExample.Criteria;

@Service
public class GoodsService {

	 @Resource
	 private GoodsMapper gm;

	public List<Goods> findAll() {
		return gm.selectByExample(new GoodsExample());
	}

	public void insert(Goods goods) {
		gm.insert(goods);
	}

	public void delete(int id) {
		gm.deleteByPrimaryKey(id);
		
	}

	public Goods findById(int id) {
		
		return gm.selectByPrimaryKey(id);
	}
   @Transactional(rollbackFor = Exception.class)
	public void update(Goods goods) {
		gm.updateByPrimaryKey(goods);
		int i=9/0;
	}

	public List<Goods> findByName(String name) {
		GoodsExample ge = new GoodsExample();
		Criteria c =ge.createCriteria();
		c.andNameLike("%"+name+"%");
		return gm.selectByExample(ge);
	}
	 
}