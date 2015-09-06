package com.codingpractise.java.concurrency;

import java.util.ArrayList;
import java.util.Random;

public class MultipleLocksSynch {

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	private static ArrayList<Integer> list1 = new ArrayList<Integer>();
	private static ArrayList<Integer> list2 = new ArrayList<Integer>();
	
	Random rand = new Random();

	private void nonSynchStageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(rand.nextInt(100));
	}

	private void nonSynchStageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(rand.nextInt(100));
	}
	
	public void nonSynchProcesses() {
		for (int i = 0; i<1000; i++) {
			nonSynchStageOne();
			nonSynchStageTwo();
		}
	}
	
	private synchronized void synchedStageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(rand.nextInt(100));
	}
	
	private synchronized void synchedStageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(rand.nextInt(100));
	}
	
	public void synchedProcess() {
		if(!list1.isEmpty()) list1.clear();
		if(!list2.isEmpty()) list2.clear();
		
		for (int i=0; i<1000; i++) {
			synchedStageOne();
			synchedStageTwo();
		}
	}
	
	private void multiLockStageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list1.add(rand.nextInt(100));
	}
	
	private void multiLockStageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		list2.add(rand.nextInt(100));
	}

	public void multiLockProcess() {
		if(!list1.isEmpty()) list1.clear();
		if(!list2.isEmpty()) list2.clear();
		
		for (int i = 0; i<1000; i++) {
			multiLockStageOne();
			multiLockStageTwo();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting the program...");
		final MultipleLocksSynch multipleLocksSynch = new MultipleLocksSynch();
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.nonSynchProcesses();
			}
			
		});
		
		Thread t2 = new Thread( new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.nonSynchProcesses();
			}
			
		});
		
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken for the Non-Synchronized Processes = " + (end - start));
		System.out.println("List1 size: " + list1.size());
		System.out.println("List2 size: " + list2.size());
		System.out.println("Two threads are working, notice that the Number of items in the list may not always be '2000', as is expected.");
		System.out.println("The Process completes quickly, but may not be accurate.");
		
		start = System.currentTimeMillis();
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.synchedProcess();
			}
		});
		
		t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.synchedProcess();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		end = System.currentTimeMillis();
		
		System.out.println("Time taken for the Method level Synchronized Processes = " + (end - start));
		System.out.println("List1 size: " + list1.size());
		System.out.println("List2 size: " + list2.size());
		System.out.println("The 'synchronized' keyword puts a Class level Lock, hence, when Thread 1 is locking StageOne method, Thread 2 cannot continue.");
		System.out.println("The time taken is twice, but Process completed correctly.");
		
		start = System.currentTimeMillis();
		t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.multiLockProcess();
			}
		});
		
		t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				multipleLocksSynch.multiLockProcess();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		end = System.currentTimeMillis();
		
		System.out.println("Time taken for the Multi-Locked Synchronized-Block Processes = " + (end - start));
		System.out.println("List1 size: " + list1.size());
		System.out.println("List2 size: " + list2.size());
		System.out.println("Using Local locks that allows processes to complete in Synchronized manner, with lesser time spent on waiting.");
	}

}
