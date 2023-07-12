package com.springboot.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController 
{
	Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@GetMapping("/greeting/{name}")
	public String greeting(@PathVariable String name) {
		logger.debug("Request of SL4J {} ", name); //SL4J (As no use of concatenation hence can save the memory
		logger.debug("Request of Log4J {} " + name); //Log4J
		if(name.equals("test"))
		{
			throw new RuntimeException("Error occurred.....");
		}
		String str = "Hello " + name;
		logger.debug("Response {}", str);
		return str;
	}
}
