package com.codingpractise.java.concurrency.waitAndNotify;

public class MainWaitNotifyApp {

	public static void main(String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		Thread producerThread = new Thread(new Runnable() {
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread consumerThread = new Thread(new Runnable() {
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();
	}

}
