package com.codingpractise.java.concurrency.reentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Process {

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	public void increment() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}

	public void firstThread() {
		lock.lock();
		
		System.out.println("Waiting...");
		try {
			// similar to wait()
			cond.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Got awakened");
		
		try {	
			// There is a possibility that an exception could be thrown in the method,
			// hence, always put the method under lock in a try-FINALLY block
			// with the lock.unlock() in finally block.
			increment();
		}
		finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("resource")
	public void secondThread() {
		lock.lock();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Press the enter key");
		new Scanner(System.in).nextLine();
		System.out.println("Enter key obtained");
		// similar to notify()
		cond.signal();
		// It will awaken the other Thread after completing this execution stack
		// The execution stack should unlock the lock, else the other thread will still have to wait for the lock to be unlocked, even if the signal() has been made.
		System.out.println("Signal sent from secondThread()");
		try {
			
			increment();
		}
		finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("Count is: " + count);
	}
}
