package com.datastructures.java.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.datastructures.java.hashMap.customHashMap.HashMapCustom;

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
		
		HashMapCustom< String, String> testMap = new HashMapCustom<String, String>();
		testMap.put("Test1Key", "Test1Value");
		testMap.put("Test2key", "Test2Value");
		testMap.display();
		
		HashSet<String> set = new HashSet<String>();
		set.add("String1");
		set.add("String2");
		set.add("String1");
		Iterator<String> setIterator = set.iterator();
		while(setIterator.hasNext()) {
			String val = setIterator.next();
			System.out.println("Set value now : " + val); //Duplicate values have been removed.
		}
	}

}
