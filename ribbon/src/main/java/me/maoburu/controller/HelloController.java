package me.maoburu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.maoburu.service.HelloService;

@RestController
public class HelloController {
	
	@Autowired
	HelloService helloService;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@RequestMapping("/hello")
	public String hi(@RequestParam String name) {
		this.loadBalancerClient.choose("service-B");//随机访问策略
		return helloService.hiService(name);
	}
	
}
