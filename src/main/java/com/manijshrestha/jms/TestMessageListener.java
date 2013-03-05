package com.manijshrestha.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * Class that Listens for a message on inQueue, for each of the message sends a
 * message to outQueue via testMessageSender
 * 
 * @author manijshrestha
 * 
 */
public class TestMessageListener implements MessageListener {

	public TestMessageSender testMessageSender;

	public static final Logger logger = Logger
			.getLogger(TestMessageListener.class);

	public void onMessage(Message message) {
		logger.info("Message Received : [ " + message + " ]");
		if (message instanceof TextMessage) {
			try {
				String msgText = ((TextMessage) message).getText();
				logger.debug("About to process message: " + msgText);

				this.testMessageSender.sendMessage(msgText);

			} catch (JMSException exp) {
				String errMsg = "An error occurred extracting message";
				logger.error(errMsg, exp);
			}
		} else {
			String errMsg = "Message is not of expected type TextMessage";
			logger.error(errMsg);
			throw new RuntimeException(errMsg);
		}

	}

	public void setTestMessageSender(TestMessageSender testMessageSender) {
		this.testMessageSender = testMessageSender;

	}

}
