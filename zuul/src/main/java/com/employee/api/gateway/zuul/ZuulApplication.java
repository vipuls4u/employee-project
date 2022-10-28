package com.employee.api.gateway.zuul;

import com.employee.api.gateway.zuul.filter.ErrorFilter;
import com.employee.api.gateway.zuul.filter.PostFilter;
import com.employee.api.gateway.zuul.filter.PreFilter;
import com.employee.api.gateway.zuul.filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {

		if (System.getProperty("registration.server.hostname") == null)
			System.setProperty("registration.server.hostname", "localhost");

		SpringApplication.run(ZuulApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
