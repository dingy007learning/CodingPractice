package com.datastructures.java.stack_queue;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueue<E> implements Iterable<E>{
	
	private LinkedList<E> list = new LinkedList<E>();

	//Constructor default
	
	//enqueue(E data); E dequeue(); boolean isEmpty(); addItems(MyQueue<? extends E> q)
	
	public void enqueue(E data){
		list.addLast(data);
	}
	
	public E dequeue(){
		return list.poll();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public void addItems(MyQueue <? extends E> q) {
		while(!q.isEmpty()) {
			list.addLast(q.dequeue());
		}
	}
	
	public int getSize(){
		return list.size();
	}
	
	public static void main(String[] args) {
		MyQueue<Character> myQ = new MyQueue<Character>();
		myQ.enqueue('a');
		myQ.enqueue('b');
		myQ.enqueue('c');
		int size = myQ.getSize();
		
		for (int i =0; i<size; i++) {
			System.out.println("Size of MyQ: " + myQ.getSize());
			System.out.println("Deque " + i + " : " + myQ.dequeue());
			
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

}
