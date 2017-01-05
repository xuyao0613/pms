package com.pms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IVehicleDao;
import com.pms.entity.Vehicle;
import com.pms.service.IVehicleService;

@Service("vehicleService")
public class VehicleServiceImpl implements IVehicleService {
	@Autowired
	private IVehicleDao vehicleDao;

	@Override
	public Vehicle getById(String id) {
		return this.vehicleDao.getById(id);
	}

	@Override
	public int delete(String id) {
		return this.vehicleDao.delete(id);
	}

	@Override
	public List<Vehicle> list(Map<String, Object> param, String page, String pageSize, String orderBy) {
		int i_page = Integer.parseInt(page);
		int i_pageSize = Integer.parseInt(pageSize);
		return this.vehicleDao.select(param, i_page, i_pageSize, orderBy);
	}

}
