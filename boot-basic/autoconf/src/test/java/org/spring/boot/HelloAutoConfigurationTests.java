package org.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.spring.helloservice.ConsoleHelloService;
import org.spring.helloservice.HelloService;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class HelloAutoConfigurationTests {

//	@Rule
//	public ExpectedException thrown = ExpectedException.none();
//	
	@Rule
	public OutputCapture output = new OutputCapture();
	
	//private ConfigurableApplicationContext context;
	
	private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
			.withConfiguration(AutoConfigurations.of(HelloAutoConfiguration.class));
	
	
//	@After
//	public void closeContext() {
//		if(this.context != null) {
//			this.context.close();
//		}
//	}
//	
	@Test
	public void defaultServiceIsAutoConfigured(){
		this.contextRunner.run(context -> {
			assertThat(context).hasSingleBean(HelloService.class);
			context.getBean(HelloService.class).sayHello("Hello");
			assertThat(this.output.toString()
					.contains("Hello World!"));
		});
	}
	
	@Test
	public void defaultServiceBacksOff() {
		this.contextRunner
			.withUserConfiguration(UserConfiguration.class)
			.run(context -> {
			assertThat(context).hasSingleBean(HelloService.class);
			context.getBean(HelloService.class).sayHello("Works");
			assertThat(this.output.toString()
					.contains("Mine Works**"));
		});
	}
	
	@Configuration
	static class UserConfiguration {
		@Bean
		public HelloService helloService() {
			return new ConsoleHelloService("Mine","**");
		}
	}
//	
//	private void load(Class config,String... env) {
//		AnnotationConfigApplicationContext ctx = null;
//	}
//	
	

//	@Test
//	public void contextLoads() {
//	}

}
