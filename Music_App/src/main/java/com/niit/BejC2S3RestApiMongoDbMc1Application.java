package com.niit;

import com.niit.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BejC2S3RestApiMongoDbMc1Application {

	public static void main(String[] args) {
		SpringApplication.run(BejC2S3RestApiMongoDbMc1Application.class, args);
	}

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new JwtFilter());
		frb.addUrlPatterns("/trackdata/v1/getalltracks","/trackdata/v1/savetrack");
//		frb.addUrlPatterns("/customerdata/v1/*");
		return frb;
	}

}
