package com.codingpractise.java.concurrency.reentrantLocks.deadlocks;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Process {

	private Account acc1 = new Account();
	private Account acc2 = new Account();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	// locks should always be locked in the same order to prevent deadlocks
	private void acquireLocks(Lock lock1, Lock lock2) {
		while(true) {
			// Acquire locks
			boolean gotLock1 = false;
			boolean gotLock2 = false;
			
			try {
				gotLock1 = lock1.tryLock(2, TimeUnit.SECONDS);
				gotLock2 = lock2.tryLock(2, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally {
				if (gotLock1 && gotLock2) {
					return;
				}
				if(gotLock1) {
					lock1.unlock();
				}
				if(gotLock2) {
					lock2.unlock();
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void firstThread() {
		Random rand = new Random();

		for (int i=0; i<1000; i++) {
			acquireLocks(lock1, lock2);
			try {
				Account.transfer(acc1, acc2, rand.nextInt(100));
			}
			finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void secondThread() {
		Random rand = new Random();

		for (int i=0; i<1000; i++) {
			
			// putting Lock2 first in this thread, causes a DEADLOCK
			// lock1 has been acquired by firstThread(), but
			// lock2 has been acquired by secondThread()
			// so both have to wait for the other for the locks to be released.
			/*
			lock2.lock();
			lock1.lock();
			*/
			acquireLocks(lock1, lock2);
			try {
			Account.transfer(acc2, acc1, rand.nextInt(100));
			}
			finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 Balance:" + acc1.getBalance());
		System.out.println("Account 2 Balance:" + acc2.getBalance());
		System.out.println("Total Balance:" + (acc2.getBalance() + acc1.getBalance())) ;
	}
}
