/**
 * 
 */
package com.datastructures.java.graph;

import java.util.Random;

/**
 * Trying out example from Algorithms Book by R.Sedgewick and K.Wayne
 *
 */
public class EdgeWeightedDiGraph {

	private final int V;	// Total number of Vertices in the graph
	private int E;			// Total number of Edges in the graph
	private int[] indegree;
	private Bag<DirectedEdge>[] adj; // Adjacency list for a particular Vertex eg. adj[v] = Adjacency list for 'v'
	
	
	/**
	 * Initializes an empty edge-weighted directed graph with V vretices and 0 edges.
	 * @param V the number of Vertices
	 * @throws IllegalArgumentException if V < 0
	 */
	public EdgeWeightedDiGraph(int V) {
		if (V < 0) throw new IllegalArgumentException ("Number of Vertices should be more than or equal to 0.");
		this.V = V;
		this.E = 0;
		this.indegree = new int[V];
		adj = (Bag<DirectedEdge>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<DirectedEdge>();
		}
	}
	
	public EdgeWeightedDiGraph(int V, int E) {
		this(V);
		if (E < 0) throw new IllegalArgumentException ("Number of Edges should be more than or equal to 0.");
		for (int i = 0; i < E; i++ ) {
			int v = RandomUtil.uniform(V);
			int w = RandomUtil.uniform(V);
			double weight = .01 * RandomUtil.uniform(100);
			DirectedEdge e = new DirectedEdge(v, w, weight);
			addEdge(e);
		}
		
		
	}
	
	public void addEdge(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		validateVertex(v);
		validateVertex(w);
		adj[v].add(e);
		E++;
	}
	
    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
    /**
     * Returns a string representation of this edge-weighted digraph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists of edges
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        EdgeWeightedDiGraph G = new EdgeWeightedDiGraph(10000, 1000000);
        System.out.println(G);
    }
}
