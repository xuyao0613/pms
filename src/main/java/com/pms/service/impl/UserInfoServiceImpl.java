package com.pms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.dao.IUserInfoDao;
import com.pms.entity.UserInfo;
import com.pms.service.IUserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService {
	@Autowired
	private IUserInfoDao userDao;
	
	@Override
	public UserInfo getById(String userId) {
		return this.userDao.getById(userId);
	}

	@Override
	public List<UserInfo> list(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}
	

}