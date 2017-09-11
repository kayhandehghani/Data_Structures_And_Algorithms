import java.util.Arrays;
import java.util.Stack;

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
		if (array.length > 1) {
			size = array.length;
			middle = size / 2;
			int[] leftArray = Arrays.copyOfRange(array, 0, middle);
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

		while (indx1 < leftArray.length && indx2 < rightArray.length) {
			if (leftArray[indx1] < rightArray[indx2]) {
				orginal[idx++] = leftArray[indx1++];
			} else {
				orginal[idx++] = rightArray[indx2++];
			}
		}

		while (indx1 < leftArray.length) {
			orginal[idx++] = leftArray[indx1++];
		}
		while (indx2 < rightArray.length) {
			orginal[idx++] = rightArray[indx2++];
		}
	}

	/*
	 * ============================================================
	 * Iterative in-place Insertion Sort for arrays on integers in
	 * ascending order
	 * ============================================================
	 */
	public static void insertionSort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			int currentElement = input[i];
			int j = i - 1;
			while (j >= 0 && currentElement < input[j]) { // the order of logical AND is important
				input[j + 1] = input[j--];
			}
			input[j + 1] = currentElement;
		}
	}

	/*
	 * ============================================================
	 * Recursive in-place Quick Sort for arrays on integers in
	 * scending order	 
	 * ============================================================
	 */
	public static void quickSortRecursive(int[] input) {
		quickSortRecursiveHelper(input, 0, input.length - 1);
	}

	private static void quickSortRecursiveHelper(int[] input, int low, int high) {
		if (high > low) { // implicit base case
			int splitIndx = partition(input, low, high);
			quickSortRecursiveHelper(input, low, splitIndx - 1);
			quickSortRecursiveHelper(input, splitIndx + 1, high);
		}
	}

	/*
	 * ============================================================
	 * Iterative Quick Sort for arrays on integers in
	 * scending order	 
	 * ============================================================
	 */
	public static void quickSortIterative(int[] input) {
		quickSortIterativeHelper(input, 0, input.length - 1);
	}

	private static void quickSortIterativeHelper(int[] input, int low, int high) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(low);
		stack.push(high);

		while(!stack.empty()) {
			high = stack.pop();
			low = stack.pop();
			int splitIndx = partition(input, low, high);

			if(splitIndx - 1 > low) { // if there is a left side, partition it next
				stack.push(low);
				stack.push(splitIndx - 1);
			}
			
			if(splitIndx + 1 < high) { // if there is a right side, partition it next
				stack.push(splitIndx + 1);
				stack.push(high);
			}
		}
	}

	/*
	 * ============================================================
	 * Pivot around the element at 'high' index so that all 
	 * elements smaller than it are to its left and all elements 
	 * larger to its right.
	 * returns the split index.
	 * ============================================================
	 */
	private static int partition(int[] array, int low, int high) {
		int pivot = array[high];
		int splitIndx = low - 1;
		for (int i = low; i < high; i++) {
			if (array[i] < pivot) {
				splitIndx++;
				swap(array, i, splitIndx); // move smaller element to left side of pivot index
			}
		}
		swap(array, ++splitIndx, high);
		return splitIndx;
	}

	/*
	 * ============================================================
	 * Swap the elements at indexes i and j
	 * ============================================================
	 */
	private static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}
