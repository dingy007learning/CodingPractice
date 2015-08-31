package com.codingpractise.java.concurrency;

public class ThreadExtended extends Thread {
	private String name;
	public ThreadExtended(String name){
		this.name=  name;
	}
	@Override
	public void run() {
		System.out.println("Extendeded Thread " + name +" is Running...");

		for (long i = 0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());
			if (Thread.currentThread().isDaemon()) {
				System.out.println("Daemon Extendeded thread: " + Thread.currentThread().getName());
			}
			System.out.printf(i+", ");
		}
	}

}
