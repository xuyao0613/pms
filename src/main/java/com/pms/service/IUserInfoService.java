package com.pms.service;

import java.util.List;
import java.util.Map;

import com.pms.entity.UserInfo;

public interface IUserInfoService {
	public UserInfo getById(String id);

	public List<UserInfo> list(Map<String, Object> param);
	
	// public List<UserInfo> getUserInfoByPage(int page,int pageSize,String
	// orderBy);
}
