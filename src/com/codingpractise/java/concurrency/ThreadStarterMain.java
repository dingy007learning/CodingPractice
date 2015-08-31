package com.codingpractise.java.concurrency;

public class ThreadStarterMain {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyRunnable("a"),"Threada");
		Thread t2 = new Thread(new MyRunnable("b"),"Threadb");
		Thread t3 = new Thread(new MyRunnable("b"),"Threadc");
		
		Thread et1 = new Thread(new ThreadExtended("ea"), "ExThreadet1");
		Thread et2 = new Thread(new ThreadExtended("eb"), "ExThreadet2");
		Thread et3 = new Thread(new ThreadExtended("ec"), "ExThreadet3");
		
		
		t1.start();
		t1.join(); // t1 is given priority to finish before starting the other threads
		t2.setDaemon(true); // setting thread 2 as daemon, it will become a low priority daemon thread
		t2.start();
		t3.start();
		
		et1.start();
		et2.start();
		et3.start();
		et1.join();
		et2.join();
		et3.join();
		
		t2.join();
		t3.join();
		
		
		
	}

}
