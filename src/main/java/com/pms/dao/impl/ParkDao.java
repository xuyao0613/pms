package com.pms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.pms.dao.IParkDao;
import com.pms.entity.Park;
import com.pms.mapper.ParkMapper;

@Repository
public class ParkDao implements IParkDao {

	@Autowired
	private ParkMapper mapper;

	@Override
	public int insert(Park park) {
		return this.mapper.insert(park);
	}

	@Override
	public int delete(String id) {
		return this.mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Park park) {
		return this.mapper.updateByPrimaryKeySelective(park);
	}

	@Override
	public List<Park> select(Map<String, Object> param, int page, int pageSize, String orderBy) {
		PageHelper.startPage(page, pageSize, orderBy);
		return this.mapper.select(param);
	}

	@Override
	public Park getById(String id) {
		return this.mapper.selectByPrimaryKey(id);
	}

}
