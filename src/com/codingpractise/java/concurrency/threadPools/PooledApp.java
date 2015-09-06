package com.codingpractise.java.concurrency.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PooledApp {
	public class Processor implements Runnable {
		
		private int id;
		public Processor(int id) {
			this.id = id;
		}
		
		@Override
		public void run() {
			System.out.println("Starting " + id);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Completed: " + id);
		}
	}

	public static void main(String[] args) {
		PooledApp app = new PooledApp();
		// Create a Thread Pool with 2 Worker Threads;
		//  'ExecutorService' has a managerial thread that manages the Thread pool and allocation of Tasks to Threads;
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (int i =1; i<6; i++) {
			executor.submit(app.new Processor(i));
		}
		//Shutdown Executor so that it cannot get new Tasks;
		executor.shutdown();
		System.out.println("All Tasks are submitted...");
		System.out.println("The ExecutorService is handling the assigning of Tasks now.");
		//Timeout for all Tasks to finish
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All Tasks completed...");
	}



}
