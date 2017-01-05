package com.pms.mapper;

import java.util.List;
import java.util.Map;

import com.pms.entity.Park;

public interface ParkMapper {
	int deleteByPrimaryKey(String id);

	int insert(Park record);

	int insertSelective(Park record);

	Park selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(Park record);

	int updateByPrimaryKey(Park record);

	List<Park> select(Map<String, Object> param);

}