package Algorithms;

import java.util.Arrays;

public class SearchAndSortAlgorithms {

	/*
	 * ============================================================ 
	 * Iterative binary search algorithm for an array of integers 
	 * Pre: <array> is sorted in ascending order 
	 * Post: returns true only if <array> contains <value>
	 * ============================================================
	 */
	public static boolean binarySearch(int[] array, int value) {
		int left = 0; // left index
		int right = array.length - 1; // right index
		int middle;

		while (right >= left) {
			middle = (left + right) / 2; // middle index
			if (array[middle] < value) {
				// search upper part of the sub_array
				left = middle + 1;
			} else if (array[middle] > value) {
				// search lower part of the sub_array
				right = middle - 1;
			} else {
				// <value> found
				return true;
			}
		}

		// <value> not found
		return false;
	}

	/*
	 * ============================================================
	 * Recursive merge sort algorithm
	 * Post: the argument <array> is sorted in ascending order
	 * ============================================================
	 */
	public static void mergeSort(int[] array) {
		int middle;
		int size;
		if( array.length > 1) {
			size = array.length;
			middle =  size/2;
			int[] leftArray = Arrays.copyOfRange(array, 0, middle );
			int[] rightArray = Arrays.copyOfRange(array, middle, size);
			
			mergeSort(leftArray);
			mergeSort(rightArray);
			
			merge(array, leftArray, rightArray);
		}
	}
	
	/*
	 * ============================================================
	 * Pre: <array1> and <array2> are sorted in ascending order
	 * Post: <finalArray> which is has the elements of 
	 * <array1> and <array2> is sorted in ascending order
	 * ============================================================
	 */
	private static void merge(int[] orginal, int[] leftArray, int[] rightArray) {
		int idx = 0, indx1 = 0, indx2 = 0; 
		
		while( indx1 < leftArray.length && indx2 < rightArray.length ) {
			if( leftArray[indx1] < rightArray[indx2]) {
				orginal[idx++] = leftArray[indx1++];	
			}
			else {
				orginal[idx++] = rightArray[indx2++];	
			}
		}
		
		while( indx1 < leftArray.length ) {
			orginal[idx++] = leftArray[indx1++];
		}
		while( indx2 < rightArray.length ) {
			orginal[idx++] = rightArray[indx2++];	
		}
	}
	
}
