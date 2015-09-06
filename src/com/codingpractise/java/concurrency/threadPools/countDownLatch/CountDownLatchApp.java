package com.codingpractise.java.concurrency.threadPools.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class Processor implements Runnable{
	private CountDownLatch latch;
	
	
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}


	@Override
	public void run() {
		System.out.println("Started..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Ensure that the Latch is countedDown, else any latch.await() will keep waiting forever!
		latch.countDown();
	}
}
public class CountDownLatchApp {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i =0; i<6; i++) {
			executor.submit(new Processor(latch));
		}
		executor.shutdown();
		System.out.println("ExecutorService is Shutdown Now.");
		
		try {
			// Waits for the latch to finish counting down.
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed.");
	}

}
