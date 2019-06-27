package org.springboot.basic.jmsbasic;

import javax.jms.JMSException;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class SampleMessageConverter implements MessageConverter {


	@Override
	public javax.jms.Message toMessage(Object object, javax.jms.Session session)
			throws JMSException, MessageConversionException {
		
		return null;
	}

	@Override
	public Object fromMessage(javax.jms.Message message) throws JMSException, MessageConversionException {
		
		return null;
	}
}
