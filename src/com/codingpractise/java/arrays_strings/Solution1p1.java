package com.codingpractise.java.arrays_strings;

public class Solution1p1 {

	public static boolean isUniqueChars(String str) {
		boolean[] charsArray = new boolean[128];
		for (int i = 0; i<str.length(); i++) {
			int c = str.charAt(i);
			if (charsArray[c]!=false) {
				return false;
			}
			charsArray[c] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] testArray = {"test1", "abcde", "thisisbad"};
		for (String str : testArray) {
			System.out.println("Checking value for: " + str);
			System.out.println(Solution1p1.isUniqueChars(str));
		}
	}
}
