package org.springboot.basic.jmsbasic.sender;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Queue;

import org.springboot.basic.jmsbasic.dao.Employee;
import org.springframework.jms.core.JmsTemplate;

public class SampleJmsMessageSender {

	private JmsTemplate jmsTemplate;
	private Queue queue;

// setters for jmsTemplate & queue

	public void simpleSend() {
		jmsTemplate.send(queue, s -> s.createTextMessage("hello queue world"));
	}

	public void sendMessage(Employee employee) {
		System.out.println("Jms Message Sender : " + employee);
		Map<String, Object> map = new HashMap<>();
		map.put("name", employee.getName());
		map.put("age", employee.getAge());
		jmsTemplate.convertAndSend(map);
	}
}
