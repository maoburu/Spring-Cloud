package me.maoburu.application;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {
	@Value("${server.port}")
	int port;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String hi() {
		return "hello";
	}
	
	@RequestMapping("/hi")
	public String demo(@RequestParam("name") String name) {
		return "hello " + name + ",this is " + port;
	}
}
