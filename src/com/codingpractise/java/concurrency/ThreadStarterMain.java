package com.codingpractise.java.concurrency;

public class ThreadStarterMain {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyRunnable("a"),"Threada");
		Thread t2 = new Thread(new MyRunnable("b"),"Threadb");
		Thread t3 = new Thread(new MyRunnable("b"),"Threadc");
		t1.start();
		t1.join();
		t2.start();
		t3.start();
		
		
	}

}
