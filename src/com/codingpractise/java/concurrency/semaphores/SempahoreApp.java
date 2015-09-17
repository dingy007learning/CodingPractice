package com.codingpractise.java.concurrency.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author dineshkp
 * Sempahores are similar to locks, but the advantage is that a Semaphore 'lock' can be released
 * from another method and can be used to limit the number of instances created across threads.
 */
public class SempahoreApp {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(1);
		// Similar to lock.lock();
		semaphore.acquire();
		
		// similar to lock.unlock();
		semaphore.release();
		System.out.println("Available permits : " + semaphore.availablePermits());
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i=0; i<200; i++) {
			executor.submit(new Runnable() {

				@Override
				public void run() {
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			});
		}
		executor.shutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}
