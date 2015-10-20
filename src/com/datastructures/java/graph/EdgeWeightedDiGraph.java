/**
 * 
 */
package com.datastructures.java.graph;

/**
 * Trying out example from Algorithms Book by R.Sedgewick and K.Wayne
 *
 */
public class EdgeWeightedDiGraph {

	private final int V;	// Total number of Vertices in the graph
	private int E;			// Total number of Edges in the graph
	private int[] indegree;
//	private Bag<DirectedEdge>[] adj; // Adjacency list for a particular Vertex eg. adj[v] = Adjacency list for 'v'
	
	
	public EdgeWeightedDiGraph(int V) {
		if (V < 0) throw new IllegalArgumentException ("Number of Vertices should be more than or equal to 0.");
		this.V = V;
		this.E = 0;
		this.indegree = new int[V];
//		adj = (Bag<DirectedEdge>[V]);
	}
	
//	public Edge
}
