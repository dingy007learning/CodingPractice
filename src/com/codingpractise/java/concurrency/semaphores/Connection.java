package com.codingpractise.java.concurrency.semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
	private Connection() {

	}

	private static Connection instance = new Connection();
	private int connections = 0;
	// ONLY a Maximum of 10 connections will be created
	private Semaphore sem = new Semaphore(10, true);

	public static Connection getInstance() {
		return instance;
	}

	public void connect() throws InterruptedException {
		sem.acquire();
		try {
			doConnect();
		}
		finally {
			sem.release();
		}
	}

	public void doConnect() throws InterruptedException {
		synchronized (this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}

		Thread.sleep(2000);

		synchronized (this) {
			connections--;
		}

	}
}
