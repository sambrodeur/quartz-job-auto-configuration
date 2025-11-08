package com.koenig.example.quartz.job.auto.configuration;

import com.koenig.example.quartz.job.auto.configuration.config.properties.QuartzProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(QuartzProperties.class)
public class QuartzJobAutoConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzJobAutoConfigurationApplication.class, args);
	}

}
