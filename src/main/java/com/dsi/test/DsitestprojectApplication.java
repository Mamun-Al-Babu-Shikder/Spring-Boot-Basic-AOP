package com.dsi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DsitestprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsitestprojectApplication.class, args);
	}

}
