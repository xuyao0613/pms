package com.pms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@RequestMapping("/getDemo")	
	public Object index(){
		Map<String, String> demo = new HashMap<>();
		demo.put("hello","world");
		return demo;
	}
}
