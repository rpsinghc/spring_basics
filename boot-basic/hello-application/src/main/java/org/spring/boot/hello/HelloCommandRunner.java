package org.spring.boot.hello;

import org.spring.helloservice.HelloService;
import org.springframework.boot.CommandLineRunner;

public class HelloCommandRunner implements CommandLineRunner {

	private final HelloService helloService;
	
	public HelloCommandRunner(HelloService helloService) {
		this.helloService = helloService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		this.helloService.sayHello("World");
		
	}
	

}
