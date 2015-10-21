/**
 * 
 */
package com.datastructures.java.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Trying out example from Algorithms Book by R.Sedgewick and K.Wayne
 *  
 *
 */
public class Bag<Item> implements Iterable<Item> {
	private int N;
	private Node<Item> first;
	
	/**
	 * private Linked List class; 
	 */	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	/**
	 * Initialize an empty Bag.
	 */
	public Bag() {
		first = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Returns the number of items in the Bag.
	 * @return number of items in Bag
	 */
	public int size() {
		return N;
	}
	
	/**
	 * Add item to the bag.
	 * @param item
	 */
	public void add(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;
		
		public ListIterator(Node<Item> first) {
			current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Not supported.");
		}
		
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("No next item available.");
            Item item = current.item;
            current = current.next; 
            return item;
        }
	}

}
