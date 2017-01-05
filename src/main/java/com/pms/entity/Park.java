package com.pms.entity;


/**
 * 停车场
 */
public class Park extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1449305321730062704L;
	
	private String parkName;
	
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
}
