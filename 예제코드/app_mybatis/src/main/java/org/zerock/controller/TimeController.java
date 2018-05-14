package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.persistence.TimeMapper;

@RestController

public class TimeController {

	@Autowired
	private TimeMapper mapper;
	
	@GetMapping("/now")
	public String getTime(){
		
		return mapper.getTime();
	}
}
