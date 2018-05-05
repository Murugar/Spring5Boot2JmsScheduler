package com.iqmsoft.boot.jms.scheduler.jms;

import javax.jms.Queue;

import com.iqmsoft.boot.jms.scheduler.domain.TransactionAlert;

public interface QueueSender {
	void send(Queue queue, TransactionAlert alert);
}
