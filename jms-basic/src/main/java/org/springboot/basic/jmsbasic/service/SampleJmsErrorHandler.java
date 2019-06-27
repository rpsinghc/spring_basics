package org.springboot.basic.jmsbasic.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleJmsErrorHandler implements ErrorHandler {
 
  
 
    @Override
    public void handleError(Throwable t) {
    	log.warn("In default jms error handler...");
        log.error("Error Message : {}", t.getMessage());
    }
 
}