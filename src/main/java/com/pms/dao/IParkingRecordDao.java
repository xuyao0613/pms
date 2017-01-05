package com.pms.dao;

import java.util.List;
import java.util.Map;

import com.pms.entity.ParkingRecord;

public interface IParkingRecordDao {
    
	int insert(ParkingRecord parkRecord);

	int delete(String id);

	int update(ParkingRecord parkRecord);

	List<ParkingRecord> select(Map<String, Object> param);

	ParkingRecord getById(String id);
}