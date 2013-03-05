package com.manijshrestha.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

/**
 * This will flush the message that is populated by TestMessageSender
 * 
 * @author manijshrestha
 * 
 */
public class TestMessageFlusher implements MessageListener {

	public static final Logger logger = Logger
			.getLogger(TestMessageFlusher.class);

	public void onMessage(Message message) {
		logger.info("Flussing: [ " + message + " ]");
		// Do nothing as we just flush the message from the queue.
	}

}
