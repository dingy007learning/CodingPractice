package com.codingpractise.java.concurrency.waitAndNotify;

import java.util.Scanner;

public class Processor {

	public void produce() throws InterruptedException {
		//using class level synch
		synchronized (this) {
			System.out.println("[PRODUCER]Producer thread is running...");
			//wait() method is available on all Java Objects
			//can only be used within Synchronized code blocks, 
			// when wait() is called, the lock on the code block is returned
			// consumes minimal system resources.
			// can be resumed by: calling a notify() or a notifyAll() method
			System.out.println("[PRODUCER]Wait about to be called...");
			wait();
			System.out.println("[PRODUCER]Resumed");
		}
	}

	@SuppressWarnings("resource")
	public void consume() throws InterruptedException {
		Scanner scn = new Scanner(System.in);
		
		Thread.sleep(2000);
		// same class level synch
		synchronized(this) {
			System.out.println("[CONSUMER]Waiting for return Key: ");
			scn.nextLine();
			System.out.println("[CONSUMER]Return key pressed.");
			// Can only be called within a synchronized code block
			// notifies the code blocks that are waiting (wait()) for the same lock
			// notifyAll() notifies all threads waiting on the lock
			// notify() DOES NOT mean that the other waiting threads can start immediately, they still have to wait for the lock to be relinquished.
			notify();
			// although notify() was called earlier, the produce() method cannot continue till the lock is released after the following sleep(5000);
			System.out.println("[CONSUMER]Going to sleep for 5s");
			Thread.sleep(5000);
			System.out.println("[CONSUMER]Releasing lock now.");
		}
 		
	}

}
