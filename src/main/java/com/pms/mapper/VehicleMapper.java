package com.pms.mapper;


import java.util.List;
import java.util.Map;

import com.pms.entity.Vehicle;

public interface VehicleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    Vehicle selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
    
    List<Vehicle> select(Map<String,Object> param);
}