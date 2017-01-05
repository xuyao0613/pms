package com.pms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IParkDao;
import com.pms.entity.Park;
import com.pms.service.IParkService;

@Service("parkService")
public class ParkServiceImpl implements IParkService {

	@Autowired
	private IParkDao parkDao;

	@Override
	public Park getById(String id) {
		return this.parkDao.getById(id);
	}

	@Override
	public int delete(String id) {
		return this.parkDao.delete(id);
	}
	
	@Override
	public List<Park> list(Map<String, Object> param, String page, String pageSize, String orderBy) {
		int i_page = Integer.parseInt(page);
		int i_pageSize = Integer.parseInt(pageSize);
		return this.parkDao.select(param, i_page, i_pageSize, orderBy);
	}

	

}
