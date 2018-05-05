package com.iqmsoft.boot.jms.scheduler.jms.impl;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;
import com.iqmsoft.boot.jms.scheduler.jms.QueueSender;

@Component
public class QueueSenderImpl implements QueueSender {

	private static final Logger logger = LoggerFactory.getLogger(QueueSenderImpl.class);

	private JmsTemplate queueJmsTemplate;

	@Autowired
	public QueueSenderImpl(JmsTemplate queueJmsTemplate) {
		this.queueJmsTemplate = queueJmsTemplate;
		this.queueJmsTemplate.setPubSubDomain(false);
	}

	@Override
	public void send(Queue queue, TransactionAlert alert) {
		logger.info("Message posted to the Queue : " + queue);
		queueJmsTemplate.convertAndSend(queue, alert);
	}

}
