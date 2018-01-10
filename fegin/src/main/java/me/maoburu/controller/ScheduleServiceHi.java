package me.maoburu.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi", fallback = ScheduleServiceHiHystrix.class)
public interface ScheduleServiceHi {
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String sayHiFromClientOne(@RequestParam("name") String name);
	
}
