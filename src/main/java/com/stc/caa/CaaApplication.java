package com.stc.caa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class CaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaaApplication.class, args);
	}

}
