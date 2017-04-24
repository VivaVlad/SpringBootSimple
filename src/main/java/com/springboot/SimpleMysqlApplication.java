package com.springboot;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
@SpringBootApplication
public class SimpleMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMysqlApplication.class, args);
	}
	@RequestMapping("/")
	public String index(){
		if(dataSource()==null)
			return "Error!";
		return "Hello world!";
	}
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
}
