package com.codingpractise.java.arrays_strings;

public class Solution1p6 {
	
	public static char[][] rotate(char[][] matrix, int n){
		
		for (int layer=0; layer<n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				// save top to temp variable
				char top = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				//bottom -> left
				matrix[last - offset][first] = matrix[last][last-offset];
				//right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				//top -> last
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
	
	public static void main(String[] args) {
		char[][] inputArray =  {{'a','b','c','d'},
								{'e','f','g','h'},
								{'i','j','k','l'},
								{'m','n','o','p'}};
		System.out.println("Starting matrix");
		Solution1p6.printArray(inputArray);
		System.out.println("Printing output");
		printArray(Solution1p6.rotate(inputArray, 4));
	}
	
	public static void printArray(char[][] matrix) {

		for(char[] intRow : matrix) {
			System.out.print("[ ");
			for (char intVal : intRow) {
				System.out.print(intVal + " ");
			}
			System.out.println("]");
		}
	}

}
