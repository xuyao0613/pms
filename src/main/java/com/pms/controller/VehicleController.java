package com.pms.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.entity.Vehicle;
import com.pms.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Resource
	private IVehicleService vehicleService;
	
	@RequestMapping("/get/{id}")
	public Vehicle getById(@PathVariable("id") String id) {
		return this.vehicleService.getById(id);
	}
	
	@RequestMapping("/list")
	public Object list(@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "pageSize", defaultValue = "10") String pageSize,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		Map<String, Object> map = new HashMap<>();
		return this.vehicleService.list(map, page, pageSize, orderBy);
	}
	
	@RequestMapping("/delete/{id}")
	public Object delete(@PathVariable("id") String id) {
		return this.vehicleService.delete(id);
	}
}
