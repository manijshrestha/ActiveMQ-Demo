package com.manijshrestha.jms;

import javax.jms.Queue;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Sends a message to outQueue
 * 
 * @author manijshrestha
 * 
 */
@Service
public class TestMessageSender {

	public static final Logger logger = Logger
			.getLogger(TestMessageSender.class);

	public Queue outQueue;
	public JmsTemplate jmsTemplate;

	public void setOutQueue(Queue testQueue) {
		this.outQueue = testQueue;

	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;

	}

	public void sendMessage(String message) {
		logger.info("Sending Message: [ " + message + " ]");
		this.jmsTemplate.convertAndSend(outQueue, message);
	}

}
