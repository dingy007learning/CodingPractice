package com.codingpractise.java.concurrency;

public class ThreadStarterMain {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyRunnable("a"),"Threada");
		Thread t2 = new Thread(new MyRunnable("b"),"Threadb");
		Thread t3 = new Thread(new MyRunnable("b"),"Threadc");
		t1.start();
		t1.join(); // t1 is given priority to finish before starting the other threads
		t2.setDaemon(true); // setting thread 2 as daemon, it will become a low priority daemon thread
		t2.start();
		t3.start();
		
		
	}

}
