/**
 * 
 */
package com.datastructures.java.graph;

/**
 * Trying out example from Algorithms Book by R.Sedgewick and K.Wayne
 * 
 * The 'DirectedEdge' represents a weighted Edge. Each edge consists of the 2 vertices being connected and 
 * the weight associated on the path.
 *
 */
public class DirectedEdge {
	private final int v;
	private final int w;
	private final double weight;
	
	/**
	 * @param v
	 * @param w
	 * @param weight
	 */
	public DirectedEdge(int v, int w, double weight) {
		super();
		if (v < 0 || w < 0) throw new IndexOutOfBoundsException("Vertices cannot be negative.");
		if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is Not-A-Number.");
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
	
	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DirectedEdge [");
		builder.append(v);
		builder.append(" -> ");
		builder.append(w);
		builder.append(" ");
		builder.append(String.format("%5.2f", weight));
		builder.append("]");
		return builder.toString();
	}
/*	
	public static void main(String[] args) {
		DirectedEdge e = new DirectedEdge(12, 23, 4.67);
		System.out.println(e.toString());
	}
	
*/	
}
