package com.pms.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IParkingRecordDao;
import com.pms.entity.ParkingRecord;
import com.pms.service.IParkingRecordService;

@Service("parkingRecordService")
public class ParkingRecordServiceImpl implements IParkingRecordService{

	@Autowired
	private IParkingRecordDao parkingRecordDao;
	@Override
	public ParkingRecord getById(String id) {
		return this.parkingRecordDao.getById(id);
	}
	
}
