package com.rg.concurrency.work;

import java.util.Random;
import java.util.concurrent.Callable;

public class ProcessTransactionWork<TransactionVO> implements Callable<TransactionVO> {
	private TransactionVO value;
	
	public ProcessTransactionWork(TransactionVO value) {
		this.value = value;
	}

	public TransactionVO call() throws Exception {
		Thread.sleep((new Random()).nextInt(999));
		return value;
	}

	public TransactionVO getValue() {
		return value;
	}

	public void setValue(TransactionVO value) {
		this.value = value;
	}

}
