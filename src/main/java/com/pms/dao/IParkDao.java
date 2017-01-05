package com.pms.dao;

import java.util.List;
import java.util.Map;

import com.pms.entity.Park;

public interface IParkDao {

	int insert(Park park);

	int delete(String id);

	int update(Park park);

	List<Park> select(Map<String, Object> param,int page, int pageSize, String orderBy);

	Park getById(String id);
}