package me.maoburu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@Value("${server.port}")
	int port;
	
	@RequestMapping("/hi")
	public String demo(@RequestParam("name") String name) {
		return "hello " + name + ",this is " + port;
	}
}
