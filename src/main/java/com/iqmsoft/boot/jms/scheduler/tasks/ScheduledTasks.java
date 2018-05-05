package com.iqmsoft.boot.jms.scheduler.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iqmsoft.boot.jms.scheduler.services.ATMService;

@Component
public class ScheduledTasks {

	private ATMService atmService;

	@Autowired
	public ScheduledTasks(ATMService atmService) {
		this.atmService = atmService;
	}

	@Scheduled(initialDelay = 2000, fixedRate = 2000)
	public void generateDummyTransactions() {
		atmService.transact();
	}

}
