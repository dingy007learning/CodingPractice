package com.codingpractise.java.concurrency.interrupts;

import java.util.Random;

public class ThreadInterruptApp {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting...");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Random rand = new Random();

				for(int i=0; i<1E8; i++) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}
					/*					
					try {
						//If the thread has an interrupt set, an InterruptedEsception is thrown...
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("Interrupted.");
						break;
					}
					 */
					Math.sin(rand.nextDouble());
				}
			}
		});
		t1.start();

		// sets the interrupt flag for the thread to 1
		// should have code to check if the interrupt flag has been set
		// or the flag will be automatically checked if there is a Thread.sleep() 
		t1.interrupt();

		t1.join();

		System.out.println("Finished.");
	}

}
