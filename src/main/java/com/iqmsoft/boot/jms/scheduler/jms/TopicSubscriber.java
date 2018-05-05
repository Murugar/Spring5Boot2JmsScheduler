package com.iqmsoft.boot.jms.scheduler.jms;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;

public interface TopicSubscriber {
	void subscribe(TransactionAlert alert);
}
