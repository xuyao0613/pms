package com.pms.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.dao.BaseDao;
import com.pms.dao.IUserInfoDao;
import com.pms.entity.UserInfo;
import com.pms.mapper.UserInfoMapper;

@Repository
public class UserInfoDao extends BaseDao<UserInfoMapper>  implements IUserInfoDao {

	@Autowired
	private UserInfoMapper mapper;
//	@Override
//	public List<UserInfo> getUserInfoByPage(int page,int pageSize,String orderBy) {
//		//PageHelper.startPage(1, 2);
//		//PageHelper.orderBy("USERID desc");
//		
//		PageHelper.startPage(page, pageSize, orderBy);
//		Map<String,Object> param=new HashMap<String,Object>();
//		//param.put("userId", 1);
//		param.put("userName", "222");
//		//List<User> users=this.mapper.selectAll(param);
//		return null;
//	}

	@Override
	public int insert(UserInfo userInfo) {
		return this.mapper.insertSelective(userInfo);
	}

	@Override
	public int delete(String id) {
		return this.mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(UserInfo userInfo) {
		return this.mapper.updateByPrimaryKeySelective(userInfo);
	}

	@Override
	public List<UserInfo> select(Map<String, Object> param) {
		return this.mapper.select(param);
	}

	@Override
	public UserInfo getById(String id) {
		return this.mapper.selectByPrimaryKey(id);
	}

	
	
}
