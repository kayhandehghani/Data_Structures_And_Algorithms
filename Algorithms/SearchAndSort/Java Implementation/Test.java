package Algorithms;

public class Test {

	public static void main(String[] args) {
		
		// Test Binary Search
		int[] array = {2,5,7,8,9,34};
		
		if( SearchAndSortAlgorithms.binarySearch(array, 5) && SearchAndSortAlgorithms.binarySearch(array, 9) 
			&& !SearchAndSortAlgorithms.binarySearch(array, -8) && !SearchAndSortAlgorithms.binarySearch(array, 0)) {
			System.out.println("Success: binary search is working.");
		}
		else {
			System.out.println("Error: binary search is NOT working!");
		}
		
		// Test Merge Sort
		int[] testArray = {94, -3, 34, 23, 9, 10};
		
		SearchAndSortAlgorithms.mergeSort(testArray);
		
		boolean failed = false;
		for (int i=0; i< testArray.length-1; i++) {
			if( testArray[i] > testArray[i+1] ) {
				failed = true;
			} 
		}
		
		if(failed) {
			System.out.println("Error: merge sort is NOT working!");
		}
		else {
			System.out.println("Success: merge sort is working.");
		}
		
	}

}
