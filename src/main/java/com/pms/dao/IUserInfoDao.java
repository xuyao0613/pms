package com.pms.dao;
import java.util.List;
import java.util.Map;

import com.pms.entity.UserInfo;


public interface IUserInfoDao {
    
	int insert(UserInfo userInfo);

	int delete(String id);

	int update(UserInfo userInfo);

	List<UserInfo> select(Map<String, Object> param);

	UserInfo getById(String id);
    
}