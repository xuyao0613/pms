package com.pms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.service.IParkService;

@RestController
@RequestMapping("/park")
public class ParkController {

	@Resource
	private IParkService parkService;

	@RequestMapping("/list")
	public Object list(@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "pageSize", defaultValue = "10") String pageSize,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		Map<String, Object> map = new HashMap<>();
		return this.parkService.list(map, page, pageSize, orderBy);
	}

	@RequestMapping("/get/{id}")
	public Object getById(@PathVariable("id") String id) {
		return this.parkService.getById(id);
	}

	@RequestMapping("/delete/{id}")
	public Object delete(@PathVariable("id") String id) {
		return this.parkService.delete(id);
	}
}
