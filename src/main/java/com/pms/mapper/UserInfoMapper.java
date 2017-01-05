package com.pms.mapper;

import java.util.List;
import java.util.Map;

import com.pms.entity.UserInfo;

public interface UserInfoMapper {
	int deleteByPrimaryKey(String id);

	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);

	List<UserInfo> select(Map<String, Object> param);
}