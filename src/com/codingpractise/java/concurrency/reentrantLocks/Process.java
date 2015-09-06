package com.codingpractise.java.concurrency.reentrantLocks;

public class Process {
	
	private int count = 0;
	
	public void increment() {
		for(int i=0; i<1000; i++) {
			count++;
		}
	}
	
	public void firstThread() {
		increment();
	}
	
	public void secondThread() {
		increment();
	}
	
	public void finished() {
		System.out.println("Count is: " + count);
	}
}
