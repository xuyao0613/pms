package com.pms.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.dao.BaseDao;
import com.pms.dao.IParkingRecordDao;
import com.pms.entity.ParkingRecord;
import com.pms.mapper.ParkingRecordMapper;
@Repository
public class ParkingRecordDao extends BaseDao<ParkingRecordMapper> implements IParkingRecordDao{

	@Autowired
	private ParkingRecordMapper mapper;
	@Override
	public int insert(ParkingRecord parkRecord) {
		return this.mapper.insertSelective(parkRecord);
	}

	@Override
	public int delete(String id) {
		return this.mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(ParkingRecord parkRecord) {
		return this.mapper.updateByPrimaryKeySelective(parkRecord);
	}

	@Override
	public List<ParkingRecord> select(Map<String, Object> param) {
		return this.mapper.select(param);
	}

	@Override
	public ParkingRecord getById(String id) {
		return this.mapper.selectByPrimaryKey(id);
	}

}
