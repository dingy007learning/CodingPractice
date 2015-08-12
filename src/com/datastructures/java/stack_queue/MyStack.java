package com.datastructures.java.stack_queue;

import java.util.LinkedList;

public class MyStack {

	private int maxSize;
	private int[] arrayStack;
	private int top;
	//Constructor
	public MyStack(int size){
		this.maxSize = size;
		top = -1;
		this.arrayStack = new int[maxSize];
	}
	//int push();put(int value);int peek();boolean isEmpty();boolean isFull()

	public void put(int value) {
		if (!this.isFull()) {
			arrayStack[++top]=value;
		}
		else {
			throw new RuntimeException("Stack is full");
		}
	}

	public int push(){
		if(!this.isEmpty()) {
			return arrayStack[top--];
		}
		else {
			throw new StackOverflowError("Stack is empty");
		}
	}

	public int peek(){
		if(!this.isEmpty()) {
			return arrayStack[top];
		}
		else {
			throw new StackOverflowError("Stack is empty");
		}
	}

	public boolean isEmpty(){
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (maxSize -1 ));
	}

	public static void main(String[] args) {

		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addLast("item");
		linkedList.poll();
		MyStack stack = new MyStack(4);
		for (int i = 0; i<5; i++) {
			stack.put(i+10);
			System.out.println("Value in stack @ " + i +", is: " + stack.peek()) ;
			System.out.println("Is Stack full? : " + stack.isFull());
		}
	}



}
