package com.nt.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.nt.com.aop.LoggingAspect;
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = LoggingAspect.class))
public class Mini01TravellProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mini01TravellProjectApplication.class, args);
	}

}
