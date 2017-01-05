package com.pms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.pms.dao.BaseDao;
import com.pms.dao.IVehicleDao;
import com.pms.entity.Vehicle;
import com.pms.mapper.VehicleMapper;

@Repository
public class VehicleDao extends BaseDao<VehicleMapper> implements IVehicleDao {

	@Autowired
	private VehicleMapper mapper;

	@Override
	public int insert(Vehicle vehicle) {
		return this.mapper.insertSelective(vehicle);
	}

	@Override
	public int delete(String id) {
		return this.mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Vehicle vehicle) {
		return this.mapper.updateByPrimaryKeySelective(vehicle);
	}

	@Override
	public List<Vehicle> select(Map<String, Object> param,int page, int pageSize, String orderBy) {
		PageHelper.startPage(page, pageSize, orderBy);
		return this.mapper.select(param);
	}

	@Override
	public Vehicle getById(String id) {
		return this.mapper.selectByPrimaryKey(id);
	}

}
