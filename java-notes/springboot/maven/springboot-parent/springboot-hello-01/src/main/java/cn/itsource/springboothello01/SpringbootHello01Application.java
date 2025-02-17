package cn.itsource.springboothello01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringbootHello01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHello01Application.class, args);
	}

}
