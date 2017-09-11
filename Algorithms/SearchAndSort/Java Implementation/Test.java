public class Test {
	private static int[] srtArray1, srtArray2, srtArray3;

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
		int[] testArray1 = {94, -3, 34, 23, 9, 10};
		int[] testArray2 = {94};
		int[] testArray3 = {94, 92, 9, -9, -88};
		
		srtArray1 = testArray1.clone();
		srtArray2 = testArray2.clone();
		srtArray3 = testArray3.clone();
		
		SearchAndSortAlgorithms.mergeSort(srtArray1);
		SearchAndSortAlgorithms.mergeSort(srtArray2);
		SearchAndSortAlgorithms.mergeSort(srtArray3);
		
		if(isSortedAscending(srtArray1) && isSortedAscending(srtArray2) && isSortedAscending(srtArray3)) {
			System.out.println("Success: merge sort is working.");
		} else {
			System.out.println("Error: merge sort is NOT working!");
		}
		
		srtArray1 = testArray1.clone();
		srtArray2 = testArray2.clone();
		srtArray3 = testArray3.clone();
		SearchAndSortAlgorithms.insertionSort(srtArray1);
		SearchAndSortAlgorithms.insertionSort(srtArray2);
		SearchAndSortAlgorithms.insertionSort(srtArray3);
		
		if(isSortedAscending(srtArray1) && isSortedAscending(srtArray2) && isSortedAscending(srtArray3)) {
			System.out.println("Success: insertion sort is working.");
		}else {
			System.out.println("Error: insertion sort is NOT working!");
		}
		
		srtArray1 = testArray1.clone();
		srtArray2 = testArray2.clone();
		srtArray3 = testArray3.clone();
		SearchAndSortAlgorithms.quickSortRecursive(srtArray1);
		SearchAndSortAlgorithms.quickSortRecursive(srtArray2);
		SearchAndSortAlgorithms.quickSortRecursive(srtArray3);

		if(isSortedAscending(srtArray1) && isSortedAscending(srtArray2) && isSortedAscending(srtArray3)) {
			System.out.println("Success: quick sort (recursive) is working.");
		}else {
			System.out.println("Error: quick sort (recursive) is NOT working!");
		}

		srtArray1 = testArray1.clone();
		srtArray2 = testArray2.clone();
		srtArray3 = testArray3.clone();
		SearchAndSortAlgorithms.quickSortIterative(srtArray1);
		SearchAndSortAlgorithms.quickSortIterative(srtArray2);
		SearchAndSortAlgorithms.quickSortIterative(srtArray3);

		if(isSortedAscending(srtArray1) && isSortedAscending(srtArray2) && isSortedAscending(srtArray3)) {
			System.out.println("Success: quick sort (iterative) is working.");
		}else {
			System.out.println("Error: quick sort (iterative) is NOT working!");
		}
		
	}

	private static boolean isSortedAscending(int[] array) {
		for (int i=0; i< array.length-1; i++) {
			if( array[i] > array[i+1] ) {
				return false;
			} 
		}
		return true;
	}

	private static void printArray(int[] array) {
		System.out.println("------------------------------------------------");
		for(int el : array) {
			System.out.print(el + "\t");
		}
		System.out.println("\n------------------------------------------------");
	}

}
