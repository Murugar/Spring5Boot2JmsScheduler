package com.iqmsoft.boot.jms.scheduler.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class TransactionAlert implements Serializable {

	
	private TransactionType transactionType;
	private double amount;
	private Date transactionTimestamp;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transactionTimestamp == null) ? 0 : transactionTimestamp.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionAlert other = (TransactionAlert) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (transactionTimestamp == null) {
			if (other.transactionTimestamp != null)
				return false;
		} else if (!transactionTimestamp.equals(other.transactionTimestamp))
			return false;
		if (transactionType != other.transactionType)
			return false;
		return true;
	}

	

	private static final long serialVersionUID = -8806522230262847830L;

	public TransactionAlert() {
	}

	public enum TransactionType {
		INVALID(-1), CREDIT(0), DEBIT(1);

		private int transactionCode;

		private TransactionType(final int transactionCode) {
			this.transactionCode = transactionCode;
		}

		public int getTransactionCode() {
			return transactionCode;
		}

		// Lookup table
		private static final Map<Integer, TransactionType> lookup = new HashMap<>();

		// Populate the lookup table on loading time
		static {
			for (TransactionType transactionType : EnumSet.allOf(TransactionType.class))
				lookup.put(transactionType.getTransactionCode(), transactionType);
		}

		// This method can be used for reverse lookup purpose
		public static TransactionType get(int transactionCode) {
			return lookup.get(transactionCode);
		}

	}

	public TransactionAlert(TransactionType transactionType, double amount, Date transactionTimestamp) {
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionTimestamp = transactionTimestamp;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionTimestamp() {
		return transactionTimestamp;
	}

	public void setTransactionTimestamp(Date transactionTimestamp) {
		this.transactionTimestamp = transactionTimestamp;
	}

	@Override
	public String toString() {
		return "TransactionAlert [transactionType=" + transactionType + ", amount=" + amount + ", transactionTimestamp="
				+ transactionTimestamp + "]";
	}

}
