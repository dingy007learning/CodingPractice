package com.codingpractise.java.concurrency.threadPools.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerApp {

	//FIFO
	// (Frm jenkov.com) A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread consumerThread = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread producerThread = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();

	}
	
	private static void producer() throws InterruptedException {
		Random rand = new Random();
		
		while(true) {
			queue.put(rand.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random rand = new Random();
		while(true) {
			Thread.sleep(100);
			if(rand.nextInt(10)==0) {
				Integer value = queue.take();
				
				System.out.println("Taken value: " + value +"; Queue lenght is: " + queue.size());
			}
		}
	}
}
