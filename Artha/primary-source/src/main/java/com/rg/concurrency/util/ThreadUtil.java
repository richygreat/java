package com.rg.concurrency.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.rg.concurrency.bean.TransactionVO;
import com.rg.concurrency.work.ProcessTransactionWork;

public class ThreadUtil {
	public static final ExecutorService executorService = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("========");
			execute();
			System.out.println("========");
		}
		executorService.shutdown();
	}

	private static void execute() {
		Map<ProcessTransactionWork<TransactionVO>, Future<TransactionVO>> taskMap = new HashMap<ProcessTransactionWork<TransactionVO>, Future<TransactionVO>>();
		ProcessTransactionWork<TransactionVO> task = null;
		TransactionVO value = null;
		for (int i = 0; i < 5; i++) {
			value = new TransactionVO();
			value.setTransId(i);
			task = new ProcessTransactionWork<TransactionVO>(value);
			taskMap.put(task, executorService.submit(task));
		}
		
		for (Entry<ProcessTransactionWork<TransactionVO>, Future<TransactionVO>> entry : taskMap.entrySet()) {
			System.out.println(entry.getKey().getValue().getTransId());
		}
	}
}
