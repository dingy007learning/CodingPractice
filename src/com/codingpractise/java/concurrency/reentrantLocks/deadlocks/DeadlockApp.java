package com.codingpractise.java.concurrency.reentrantLocks.deadlocks;

import com.codingpractise.java.concurrency.reentrantLocks.deadlocks.Process;


public class DeadlockApp {

	final Process process = new Process();
	
	Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			process.firstThread();
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
			process.secondThread();
		}
	});
	
	public void doWork() throws InterruptedException {
		long start = System.currentTimeMillis();
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		process.finished();
		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start));
	}
	
	public static void main(String[] args) {
		DeadlockApp app = new DeadlockApp();
		try {
			app.doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}