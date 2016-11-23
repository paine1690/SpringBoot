package hello;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@SpringBootApplication
@ComponentScan("psxt.handler")
@ComponentScan("psxt.pagecontroller")
@ComponentScan("psxt.controller")
@ComponentScan("psxt.dbservive")
@MapperScan("psxt.mapper")
@ComponentScan("psxt.mode")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
