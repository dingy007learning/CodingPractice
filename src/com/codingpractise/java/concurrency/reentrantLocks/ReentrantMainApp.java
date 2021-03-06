package com.codingpractise.java.concurrency.reentrantLocks;

public class ReentrantMainApp {

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
		ReentrantMainApp app = new ReentrantMainApp();
		try {
			app.doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
