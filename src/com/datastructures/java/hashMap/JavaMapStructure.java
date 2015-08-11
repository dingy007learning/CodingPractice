package com.datastructures.java.hashMap;

import java.util.HashMap;
import java.util.Iterator;

// Tutorial adapted from JCG, Java Code Geeks
// http://www.javacodegeeks.com/2014/03/how-hashmap-works-in-java.html
public class JavaMapStructure {

	public static void main(String[] args) {
		Country india = new Country("India", 1000);
		Country japan = new Country("Japan", 2000);
		Country france = new Country("France", 2300);
		Country dummy1 = null;
		Country dummy2 = null;
		
		HashMap<Country, String> countryCapitalMap = new HashMap<Country, String>();
		countryCapitalMap.put(india, "Delhi");
		countryCapitalMap.put(japan, "Tokyo");
		countryCapitalMap.put(france, "Paris");
		countryCapitalMap.put(dummy1, "DummyCapital1");
		countryCapitalMap.put(dummy2, "DummyCapital2"); // If there are multiple null keys, only the last value will be stored.
		//HashTable does not allow null keys
//		int hash = hash(india.hashCode());
		
		Iterator<Country> mapIterator = countryCapitalMap.keySet().iterator();
		while(mapIterator.hasNext()) {
			Country country = mapIterator.next();
			System.out.println("----Capital:"+countryCapitalMap.get(country));
		}
	}

}
