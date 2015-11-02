package com.customUtils.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public final class InputReader {
	private static final String CHARSET_NAME = "UTF-8";
	private static Scanner scanner;

	/**
	 * Read from a file.
	 * @param file
	 */
	public InputReader(File file) {
		if (file == null) throw new NullPointerException("File cannot be null");
		try {
			scanner = new Scanner(file, CHARSET_NAME);
			scanner.useLocale(Locale.ENGLISH);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * Reads the next token from this input stream, parses it as a <tt>int</tt>,
	 * and returns the <tt>int</tt>.
	 *
	 * @return the next <tt>int</tt> in this input stream
	 */
	public int readInt() {
		return scanner.nextInt();
	}
	
	   /**
     * Reads the next token from this input stream, parses it as a <tt>double</tt>,
     * and returns the <tt>double</tt>.
     *
     * @return the next <tt>double</tt> in this input stream
     */
    public double readDouble() {
        return scanner.nextDouble();
    }

   /**
     * Reads the next token from this input stream, parses it as a <tt>float</tt>,
     * and returns the <tt>float</tt>.
     *
     * @return the next <tt>float</tt> in this input stream
     */
    public float readFloat() {
        return scanner.nextFloat();
    }

   /**
     * Reads the next token from this input stream, parses it as a <tt>long</tt>,
     * and returns the <tt>long</tt>.
     *
     * @return the next <tt>long</tt> in this input stream
     */
    public long readLong() {
        return scanner.nextLong();
    }
}
