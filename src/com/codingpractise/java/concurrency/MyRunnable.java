package com.codingpractise.java.concurrency;

import java.util.Scanner;

public class MyRunnable implements Runnable {

	private String name;
	public MyRunnable(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Thread " + name +" is Running...");
		
//		System.out.println("Enter a value: ");
//		Scanner scn = new Scanner(System.in);
//		String userval = scn.next();
//		System.out.println("User entered:" + userval);
//		
		
		for (long i = 0; i<100; i++) {
			System.out.println(Thread.currentThread().getName());	
			System.out.printf(i+", ");
		}
	}

}
