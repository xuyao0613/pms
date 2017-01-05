package com.pms.service;

import java.util.List;
import java.util.Map;

import com.pms.entity.Park;

public interface IParkService {
	public Park getById(String id);

	public int delete(String id);

	public List<Park> list(Map<String, Object> param, String page, String pageSize, String orderBy);
}
