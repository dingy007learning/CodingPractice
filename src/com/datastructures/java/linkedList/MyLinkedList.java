package com.datastructures.java.linkedList;

public class MyLinkedList<E> {

	private class Node<E>{
		private E data;
		private Node<E> next;

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head;
	//Constructor;
	public MyLinkedList() {
		this.head = null;
	}

	//Methods: addFirst(E); add(E); E getValue(int position); E getFirst(); add(E); removeFirst();

	public void addFirst(E data){
		head =  new Node<E> (data, head);
	}

	public void add(E data){
		if (this.head==null) {
			addFirst(data);
		}
		else {
			Node<E> temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<E>(data,null);
		}
	}
	
	public void removeFirst() {
		Node<E> temp = head.next;
		head = head.next;
	}
	
	public E getLast() {
		if  (head==null) return null;
		Node<E> temp = head;
		while(temp.next!=null) temp = temp.next;
		return temp.data;
	}


	public static void main(String[] args) {
		MyLinkedList<Character> linkedList = new MyLinkedList<>();
		linkedList.add('a');
		linkedList.add('b');
		linkedList.add('c');
		
		System.out.println("Printing last value:" + linkedList.getLast());
	}

}
