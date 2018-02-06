package me.maoburu;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import me.maoburu.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class Application {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	//过滤器需创建具体的bean才会生效
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
}
