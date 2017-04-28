package Algorithms;


public class SearchAlgorithms {
	
	/*============================================================
		Iterative binary search algorithm for an array of integers
		Pre: <array> is sorted in ascending order
		Post: returns true only if <array> contains <value>
	 ============================================================*/
	public static boolean binarySearch(int[] array, int value) {
		int left = 0; // left index
		int right = array.length - 1; //right index
		int middle;
	
		while(right >= left) {
			middle = (left + right)/2; //middle index
			if( array[middle] < value) {
				//search upper part of the sub_array
				left = middle + 1;
			}
			else if( array[middle] > value) {
				//search lower part of the sub_array
				right = middle - 1;
			}
			else {
				// <value> found
				return true;
			}
		}
		
		// <value> not found
		return false;
	}
}
