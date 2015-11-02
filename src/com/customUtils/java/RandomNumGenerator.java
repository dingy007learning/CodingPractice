package com.customUtils.java;

import java.util.Random;

public final class RandomNumGenerator {

	private static Random random;
	private static long seed;

	static {
		seed = System.currentTimeMillis();
		random = new Random(seed);
	}
	
	private RandomNumGenerator() {}
	
	public static void setSeed(long s) {
		seed = s;
		random = new Random(seed);
	}
	
	public static double uniform() {
		return random.nextDouble();
	}
	
    /**
     * Returns a random integer uniformly in a given range.
     * 
     * @param N number of possible integers
     * @return a random integer uniformly between 0 (inclusive) and <tt>N</tt> (exclusive)
     * @throws IllegalArgumentException if <tt>N <= 0</tt>
     */
    public static int uniform(int N) {
        if (N <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return random.nextInt(N);
    }

}
