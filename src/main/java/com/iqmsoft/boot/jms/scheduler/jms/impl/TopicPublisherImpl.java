package com.iqmsoft.boot.jms.scheduler.jms.impl;

import javax.jms.DeliveryMode;
import javax.jms.Session;
import javax.jms.Topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;
import com.iqmsoft.boot.jms.scheduler.jms.TopicPublisher;

@Component
public class TopicPublisherImpl implements TopicPublisher {

	private static final Logger logger = LoggerFactory.getLogger(TopicPublisherImpl.class);

	private Topic transactionAlertTopic;
	private JmsTemplate topicJmsTemplate;

	@Autowired
	public TopicPublisherImpl(Topic transactionAlertTopic, JmsTemplate topicJmsTemplate) {
		this.transactionAlertTopic = transactionAlertTopic;
		this.topicJmsTemplate = topicJmsTemplate;
	}

	public void publish(TransactionAlert alert) {

		topicJmsTemplate.setPubSubDomain(true);

		topicJmsTemplate.setDeliveryPersistent(true);
		topicJmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);

		topicJmsTemplate.setPriority(9);

		topicJmsTemplate.setTimeToLive(100000000000000000L);

		topicJmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

		logger.info("Alert Published to : " + transactionAlertTopic);
		topicJmsTemplate.convertAndSend(transactionAlertTopic, alert);
	}
}
