package com.iqmsoft.boot.jms.scheduler.jms;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;

public interface TopicPublisher {
	void publish(TransactionAlert alert);
}
