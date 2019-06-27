package org.springboot.basic.jmsbasic.reciver;

import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;

public class AnnotatedJMSListener {
	@JmsListener(destination = "myDestination")
	public void SampleJmsListenerMethod(Message<Order> order) { 
		
	}

}
