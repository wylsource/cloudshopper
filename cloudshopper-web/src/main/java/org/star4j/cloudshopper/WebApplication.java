package org.star4j.cloudshopper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.star4j.cloudshopper.annotation.ExcludFromComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan //设置启动时spring能够扫描到我们自己编写的servlet和filter
@MapperScan("org.star4j.cloudshopper.mapper") //用于扫描的mapper接口
@EnableCircuitBreaker
@EnableFeignClients
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludFromComponentScan.class)})
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
