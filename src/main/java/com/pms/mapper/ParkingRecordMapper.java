package com.pms.mapper;

import java.util.List;
import java.util.Map;

import com.pms.entity.ParkingRecord;

public interface ParkingRecordMapper {
	int deleteByPrimaryKey(String id);

	int insert(ParkingRecord record);

	int insertSelective(ParkingRecord record);

	ParkingRecord selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ParkingRecord record);

	int updateByPrimaryKey(ParkingRecord record);

	List<ParkingRecord> select(Map<String, Object> param);
}