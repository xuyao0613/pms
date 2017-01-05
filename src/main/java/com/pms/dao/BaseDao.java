package com.pms.dao;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<T> extends SqlSessionDaoSupport {
	
	protected T mapper;

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@PostConstruct
	public void init() {
		@SuppressWarnings("unchecked")
		Class<T> mapperType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.mapper = this.getSqlSession().getMapper(mapperType);
	}

}
