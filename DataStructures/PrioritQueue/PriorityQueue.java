import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @summary: simple implementation of a PriorityQueue of words(Strings) with integer priorities 
 * using max-heap (ArrayList-based) as the underlying DS.
 * @author: Kayhan Dehghani
 **/
public class PriorityQueue {
	private MaxHeap priorityQueue = new MaxHeap();

	public int size() {
		return priorityQueue.size();
	}

	public void insert(String word, int priority) {
		priorityQueue.insert(word, priority);
	}

	public String removeMax() {
		return priorityQueue.removeMax();
	}

	public void clear() {
		priorityQueue.clear();
	}

	public String peek() throws IndexOutOfBoundsException {
		return priorityQueue.peek();
	}

	public String toString() {
		return priorityQueue.toString();
	}

	static class MaxHeap {
		private static ArrayList<WordPriorityPair> heap = new ArrayList<WordPriorityPair>(100);

		public int size() {
			return heap.size();
		}

		public void insert(String word, int priority) {
			heap.add(new WordPriorityPair(word, priority));
			int childIdx = heap.size() - 1; // index of last element
			int parentIdx = (int) Math.floor((childIdx - 1) / 2);
			try {
				WordPriorityPair child = heap.get(childIdx);
				WordPriorityPair parent = heap.get(parentIdx);
				while (child.getPriority() > parent.getPriority()) { // keep moving child to the top of heap
					swap(childIdx, parentIdx);
					childIdx = parentIdx;
					parentIdx = (int) Math.floor((childIdx - 1) / 2);
					child = heap.get(childIdx);
					parent = heap.get(parentIdx);
				}
			} catch (Exception e) {
				// heap has onlt one element
			}
		}

		public String removeMax() {
			String string = "";

			if (heap.size() >= 1) {
				string = heap.get(0).getWord();
				int lastIdx = heap.size() - 1;
				swap(0, lastIdx); // swap first and last element
				heap.remove(lastIdx);
				heapify(0); // heapift at root
			}

			return string;
		}

		public void clear() {
			heap.clear();
		}

		public String peek() throws IndexOutOfBoundsException {
			return heap.get(0).getWord();
		}

		private void heapify(int currentIdx) {
			int leftIdx;
			int rightIdx;
			int lastIdx = heap.size() - 1;
			int largerIdx = 0;

			while (true) {
				leftIdx = 2 * currentIdx + 1;
				rightIdx = 2 * currentIdx + 2;

				if (leftIdx <= lastIdx && 
					heap.get(leftIdx).getPriority() > heap.get(currentIdx).getPriority()) {
					largerIdx = leftIdx;
				} else {
					largerIdx = currentIdx;
				}
				if(rightIdx <= lastIdx &&
				heap.get(rightIdx).getPriority() > heap.get(largerIdx).getPriority()) {
					largerIdx = rightIdx;
				}
				if(largerIdx == currentIdx) {
					break;
				}
				swap(largerIdx, currentIdx);
				currentIdx = largerIdx;
			}
		}

		public String toString() {
			String string = "[ ]";
			if (!heap.isEmpty()) {
				Iterator<WordPriorityPair> iterator = heap.iterator();
				WordPriorityPair pair = iterator.next();
				string = "[ " + pair.getWord() + "(" + pair.getPriority() + ")";

				while (iterator.hasNext()) {
					pair = iterator.next();
					string += ", " + pair.getWord() + "(" + pair.getPriority() + ")";
				}
				string += " ]";
			}
			return string;
		}

		private void swap(int i, int j) {
			WordPriorityPair temp = heap.get(i);
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}

		class WordPriorityPair {
			private String word;
			private int priority;

			public WordPriorityPair(String word, int priority) {
				this.word = word;
				this.priority = priority;
			}

			public int getPriority() {
				return priority;
			}

			public String getWord() {
				return word;
			}
		}
	}
}