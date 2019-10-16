package com.devpaulosouza.jpanaturalorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = { 
	"com.devpaulosouza.jpanaturalorder.controller",
	"com.devpaulosouza.jpanaturalorder.service.impl",
	"com.devpaulosouza.jpanaturalorder.repository",
	"com.devpaulosouza.jpanaturalorder.facade",
	"com.devpaulosouza.jpanaturalorder.model",
	"com.devpaulosouza.jpanaturalorder.exception"
 })
public class JpaNaturalOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaNaturalOrderApplication.class, args);
	}

}
