package org.springboot.basic.jmsbasic.reciver;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springboot.basic.jmsbasic.dao.Employee;
import org.springframework.jms.core.JmsTemplate;

public class SampleListener implements MessageListener {
	 
    public JmsTemplate getJmsTemplate() {
        return getJmsTemplate();
    }
 
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String msg = ((TextMessage) message).getText();
                System.out.println("Message has been consumed : " + msg);
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            throw new IllegalArgumentException("Message Error");
        }
    }
 
    public Employee receiveMessage() throws JMSException {
        Map map = (Map) getJmsTemplate().receiveAndConvert();
        return new Employee((String) map.get("name"), (Integer) map.get("age"));
    }

}
