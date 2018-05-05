package com.iqmsoft.boot.jms.scheduler.services;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;
import com.iqmsoft.boot.jms.scheduler.jms.TopicPublisher;

@Component
public class ATMServiceImpl implements ATMService {
	
	private static final Logger logger = LoggerFactory.getLogger(ATMServiceImpl.class);

	private TopicPublisher topicPublisher;

	@Autowired
	public ATMServiceImpl(TopicPublisher topicPublisher) {
		this.topicPublisher = topicPublisher;
	}

	private Random r = new Random();

	@Override
	public void transact() {

		TransactionAlert alert = new TransactionAlert(TransactionAlert.TransactionType.get(r.nextInt(2)),
				r.nextDouble(), new Date());

		logger.info("<=============================================> ");
		logger.info("Transaction Detected => " + alert);

		topicPublisher.publish(alert);
	}

}
