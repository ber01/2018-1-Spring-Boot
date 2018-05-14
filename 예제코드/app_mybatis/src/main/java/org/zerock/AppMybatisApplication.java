package org.zerock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zerock.persistence")

public class AppMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMybatisApplication.class, args);
	}
}
