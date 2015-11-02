package com.codingpractise.java.algorithms.djikstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DjikstraSP {

	public void computePaths(Vertex sourceVertex) {
		sourceVertex.setMinDistance(0);
		PriorityQueue<Vertex> priorityQ = new PriorityQueue<Vertex>();//stores data as a Heap hence advantageous for getting the next Min value;
		priorityQ.add(sourceVertex);
		
		while( !priorityQ.isEmpty()) {
			Vertex actualVertex = priorityQ.poll(); // returns Vertex with the minDistance
			
			for(Edge edge : actualVertex.getAdjacenciesList()) {
				Vertex v = edge.getTargetVertex();
				double weight = edge.getWeight();
				double minDistanceViaV = actualVertex.getMinDistance() + weight;
				
				if (minDistanceViaV < v.getMinDistance()) {
					// There is no way to just update the data in a Q, it must be removed updated and added back.
					priorityQ.remove(v);
					v.setPrevVertex(actualVertex);
					v.setMinDistance(minDistanceViaV);
					priorityQ.add(v);
					
				}
			}
		}
		
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex) {
		List<Vertex> path = new ArrayList<Vertex>();
		for(Vertex vertex = targetVertex; vertex != null; vertex= vertex.getPrevVertex()) {
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
	}
}
