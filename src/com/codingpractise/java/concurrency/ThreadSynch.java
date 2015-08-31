package com.codingpractise.java.concurrency;

import java.util.concurrent.locks.Lock;

public class ThreadSynch {
	
	private volatile int count = 0; 
	//volatile keyword might help
	// if there is an issue caused due to caching of a variable value
	// Eg. a value that can be changed from outside the Tread, needs to be 
	// monitored.
	
	public static void main(String[] args) throws InterruptedException {
		ThreadSynch app = new ThreadSynch();
		app.doProcess();
	}
	
	/**
	 * Use the Synchronised keyword so that a common variable can be updated 
	 * properly by 2 or more threads. Each Thread accesses the method and 
	 * puts a lock so that any other Thread requesting access will have to wait
	 * for its turn. 
	 */
	private synchronized void counter() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}

	private void doProcess() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// Trying to increment a common variable is a bad idea.				
/*				for(int i=0; i<10000; i++) {
					count++;
				}*/
				counter();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// Trying to increment the same common variable is a bad idea.
/*				for(int i=0; i<10000; i++) {
					count++;
				}*/
				counter();
			}
		});
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		System.out.println("Count is: " + count);
	}

}
