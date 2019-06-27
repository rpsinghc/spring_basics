package org.springboot.basic.jmsbasic.config;

import javax.jms.ConnectionFactory;

import org.springboot.basic.jmsbasic.service.SampleJmsErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;

@Configuration
@EnableJms
public class AppConfig {
 
	@Autowired
	SampleJmsErrorHandler sampleJmsErrorHandler;
	
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setErrorHandler(sampleJmsErrorHandler);
        return factory;
    }

    @Bean
	private ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory();
	}
}
