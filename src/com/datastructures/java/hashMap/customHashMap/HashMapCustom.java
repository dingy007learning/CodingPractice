package com.datastructures.java.hashMap.customHashMap;
// From JavaMadeSoEasy.com
// http://www.javamadesoeasy.com/2015/02/hashmap-custom-implementation.html

public class HashMapCustom<K, V> {

	private Entry<K,V>[] table;
	private int capacity=4;

	private static class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> next;

		public Entry(K key, V value, Entry<K,V> next){
			this.key= key;
			this.value = value;
			this.next = next;
		}
	}

	public HashMapCustom(){
		table = new Entry[capacity];
	}

	private int hash(K key){
		return Math.abs(key.hashCode())%capacity;
	}

	public void display() {
		for(int i =0;i<capacity;i++) {
			if(table[i] !=null) {
				Entry<K,V> entry = table[i];
				while(entry!=null){
					System.out.println("Key:" + entry.key + "; Value: " + entry.value);
					entry = entry.next;
				}
			}
		}
	}

	public void put(K key, V value) {
		if(key==null) return;
		
		int hash = hash(key);
		Entry<K,V> entry = new Entry<K,V>(key,value,null);
		
		if(table[hash]==null){
			table[hash]=entry;
		}
		else {
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];
			
			while(current!=null){
				if(current.key.equals(key)){
					if(previous==null){
						entry.next=current.next;
						table[hash]=entry;
						return;
					}
					else{
						entry.next=current.next;
						previous.next = entry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next=entry;
		}
	}
	
	public V get(K key){
		int hash = hash(key);
		if(table[hash] == null) {
			return null;
		}
		else {
			Entry<K,V> temp = table[hash];
			while(temp!=null){
				if(temp.key.equals(key)){
					return temp.value;
				}
				else {// look for the next Entry in the LinkedList
					temp = temp.next;
				}
			}
		}
		return null;
	}
}
