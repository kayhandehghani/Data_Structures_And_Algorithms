package Algorithms;

public class Test {

	public static void main(String[] args) {
		
		// Test Binary Search
		int[] array = {2,5,7,8,9,34};
		
		if( SearchAlgorithms.binarySearch(array, 5) && SearchAlgorithms.binarySearch(array, 9) 
			&& !SearchAlgorithms.binarySearch(array, -8) && !SearchAlgorithms.binarySearch(array, 0)) {
			System.out.println("Success: binary search is working.");
		}
		else {
			System.out.println("Error: binary search is NOT working!");
		}

	}

}
