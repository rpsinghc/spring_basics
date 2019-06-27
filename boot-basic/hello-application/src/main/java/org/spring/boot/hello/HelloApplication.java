package org.spring.boot.hello;

import org.spring.helloservice.ConsoleHelloService;
import org.spring.helloservice.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
	

	@Bean
	public HelloService helloService(){
		return new ConsoleHelloService("Howdy","!");
	}

}
	