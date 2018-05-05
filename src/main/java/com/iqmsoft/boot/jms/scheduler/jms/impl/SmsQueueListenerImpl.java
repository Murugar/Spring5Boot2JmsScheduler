package com.iqmsoft.boot.jms.scheduler.jms.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;
import com.iqmsoft.boot.jms.scheduler.jms.QueueListener;

@Component
public class SmsQueueListenerImpl implements QueueListener {

	private static final Logger logger = LoggerFactory.getLogger(SmsQueueListenerImpl.class);

	@PostConstruct
	public void init() {
		logger.info("SmsQueueListenerImpl Listener is Initialized...");
	}

	@JmsListener(destination = "${trans.alert.sms.queue}", containerFactory = "queueJmsListenerContainerFactory")
	public void receiveMessage(TransactionAlert alert) {
		logger.info("Sending SMS => <" + alert + ">");
	}

}
