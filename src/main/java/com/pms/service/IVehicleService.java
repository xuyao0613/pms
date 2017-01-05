package com.pms.service;

import java.util.List;
import java.util.Map;

import com.pms.entity.Vehicle;

public interface IVehicleService {
	public Vehicle getById(String id);
	
	public int delete(String id);
	
	public List<Vehicle> list(Map<String, Object> param, String page, String pageSize, String orderBy);
}
