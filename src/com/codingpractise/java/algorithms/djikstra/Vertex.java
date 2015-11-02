package com.codingpractise.java.algorithms.djikstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	private String name;
	private List<Edge> adjacenciesList;
	private boolean visited;
	private Vertex prevVertex;
	private double minDistance = Double.MAX_VALUE;

	public Vertex(String name) {
		this.name = name;
		this.adjacenciesList = new ArrayList<Edge>();
	}

	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPrevVertex() {
		return prevVertex;
	}

	public void setPrevVertex(Vertex prevVertex) {
		this.prevVertex = prevVertex;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Vertex otherVertex) {
		// TODO Auto-generated method stub
		return Double.compare(this.minDistance, otherVertex.minDistance);
	}
}
