package com.codingpractise.java.arrays_strings;

public class Solution1p3 {
	public static String sort(String str) {
		char[] sortedCharArray = str.toCharArray();
		java.util.Arrays.sort(sortedCharArray);
		return new String(sortedCharArray);
	}
	
	public static boolean compareStrings(String str1, String str2) {
		if (str1.length() != str2.length()) return false;
		str1 = Solution1p3.sort(str1);
		str2 = Solution1p3.sort(str2);
		
		return (str1.equals(str2));	
	}
	
	public static void main(String[] args) {
		System.out.println("Testing...");
		System.out.println(Solution1p3.compareStrings("abcd", "abdd"));
	}
}
