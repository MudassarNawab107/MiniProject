package com.nt.com.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<SimpleFilter> firstFilter() {
		FilterRegistrationBean<SimpleFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new SimpleFilter());
		registrationBean.addUrlPatterns("/api/*"); // Specify URL patterns to filter
		registrationBean.setOrder(1); // Set filter order, lower values have higher priority

		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<RequestModificationFilter> secondFilter() {
		FilterRegistrationBean<RequestModificationFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestModificationFilter());
		registrationBean.addUrlPatterns("/api/*"); // Specify URL patterns to filter
		registrationBean.setOrder(2); // Set filter order, lower values have higher priority

		return registrationBean;
	}
}
