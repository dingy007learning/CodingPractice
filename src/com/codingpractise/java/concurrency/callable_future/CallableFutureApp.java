package com.codingpractise.java.concurrency.callable_future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 *The Runnable anonymous class cannot return an object or 
 * throw an Exception from within
 * Hence we use a Callable
 * @author dineshkp
 */
public class CallableFutureApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();

		/* The Runnable anonymous class cannot return an object or 
		 * throw an Exception from within
		 * Hence we use a Callable
		 * 
			 executor.submit(new Runnable() {(new Runnable() {	
			public void run() {

				Random rand = new Random();
				int duration = rand.nextInt(1000);
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished.");
			}
		});
		 */


		Future<Integer> future = executor.submit(new Callable<Integer>() {
			// Use the below Syntax for using methods of future, but not really interested
			// in the data type ('V' should be capital in Void)
			// Future<?> future = executor.submit(new Callable<Void>() {
			
			public Integer call() throws Exception {
				Random rand = new Random();
				int duration = rand.nextInt(1000);
				
				if (duration > 500) {
					throw new IOException("Sleeping for too long...");
				}
				
				System.out.println("Starting ...");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Finished.");
				return duration;
			}
		});
		
		executor.shutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS);
		
		// The future.get() method will wait for the executing Thread to complete execution
		// and only then will it proceed.
		System.out.println("Duration was: " + future.get());
		
		// future can cancel threads
		// future has a done method to check if the thread has completed.
		
	}

}
