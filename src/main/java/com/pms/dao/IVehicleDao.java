package com.pms.dao;

import java.util.List;
import java.util.Map;

import com.pms.entity.Vehicle;

public interface IVehicleDao {
    
	int insert(Vehicle vehicle);

	int delete(String id);

	int update(Vehicle vehicle);

	List<Vehicle> select(Map<String, Object> param,int page, int pageSize, String orderBy);

	Vehicle getById(String id);
}