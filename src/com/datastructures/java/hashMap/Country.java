package com.datastructures.java.hashMap;

public class Country {
	private String name;
	private int population;
	
	public Country(String name, int population){
		this.name= name;
		this.population = population;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	public int hashCode() {
		int hashValue = 99;
		if (name.length()%2 == 0)
		{
			hashValue = 51;
		}
		return hashValue;
	}
	
	public boolean equals(Country country){
		if (this.name.equalsIgnoreCase(country.getName())) return true;
		return false;
		
	}

}
