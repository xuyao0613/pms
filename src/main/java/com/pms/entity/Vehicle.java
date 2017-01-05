package com.pms.entity;


/**
 * 车辆信息
 */
public class Vehicle extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3306516763003331618L;

	
	/**
	 * 车牌号
	 */
	private String vehicleNum;

	

	public String getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
}
