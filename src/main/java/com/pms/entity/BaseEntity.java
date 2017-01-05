package com.pms.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pms.util.CustomDateSerializer;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	protected static final long serialVersionUID = -5543219474788949155L;

	protected String id;
	@JsonSerialize(using = CustomDateSerializer.class)
	protected Date createTime;
	@JsonSerialize(using = CustomDateSerializer.class)
	protected Date updateTime;
	@JsonSerialize(using = CustomDateSerializer.class)
	protected Date deleteTime;
	protected Integer delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
