import java.util.HashMap;
import java.util.Map;

/**
 * @summary: simple implementation of a generic Singly-Linked List
 * @author: Kayhan Dehghani
 **/
public class MyLinkedList<T> {

	private Header<T> header = new Header<>();
	private int size;

	// inserts at the tail
	public void insert(T t) {
		Node<T> newNode = new Node<>(t);
		if(isEmpty()) { // if linked list is empty
			header.head = newNode;
		} else {
			header.tail.next = newNode;
		}
		header.tail = newNode;
		size++;
	}

	// deletes all instances of T
	public void deleteAllNodes(T t) {
		while(contains(t)) {
			deleteNode(t);
		}
	}

	public boolean contains(T t) {
		Node<T> current = header.head;
		while(current != null) {
			if(t.equals(current.value) || t == current) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	// deletes the first instance of T
	// returns true only if a node has been deleted
	// supports Object.equals for Objects and also primitive types equality
	public boolean deleteNode(T t) {
		if(isEmpty()){ 
			return false;
		}
		Node<T> current = header.head;
		Node<T> previous = null;
		while(current != null) {
			
			if(t.equals(current.value) || t == current.value) {
				if(current == header.head) {
					if(size == 1) {
						header.tail = null; // or header.tail = current.next
					}
					header.head = current.next; 
				} else if (current == header.tail) {
					header.tail = previous;
					header.tail.next = null;
				} else { // previous can't be null in this case
					previous.next = current.next;  // connect the the two parts before and after current node
				}
				size --;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}

	public void removeDuplicates() {
		if(isEmpty()) return;
		Map<T, T> map = new HashMap<>();
		Node<T> currentNode = header.head;
		Node<T> prevNode = null;
		while(currentNode != null) {
			if(map.containsKey(currentNode.value)) {
				prevNode.next = currentNode.next; // drop the currentNode
				size--;
			} else {
				map.put(currentNode.value, null);
				prevNode = currentNode; 
			}
			currentNode = currentNode.next;
		}
		// update the tail
		header.tail = prevNode;
		header.tail.next = null;
	}

	public T nthToLast(int n) {
		if(n > size || n < 1 || isEmpty()) {
			return null;
		}
		if(n == 1) { // first to last == tail
			return header.tail.value;
		}
		Node<T> currentNodet = header.head;

		// nth to last is at index (size - n), starting at zero!
		int idx = 0;
		while(idx != size - n) {
			currentNodet = currentNodet.next;
			idx++;
		}

		return currentNodet.value;
	}

	public T getTail() {
		if(isEmpty()) 
			return null;
		else 
			return header.tail.value;
	}

	public T getHead() {
		if(isEmpty()) 
			return null;
		else 
			return header.head.value;
	}

	public boolean isEmpty() {
		return size == 0 && header.head == null && header.tail == null;
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		header.head = null;
		header.tail = null;
		size = 0;
	}

	public String toString() {
		String result = "[ ";
		Node<T> current = header.head;
		while(current != null) {
			if(current != header.tail) {
				result = result + current.value.toString() + ", ";
			} else {
				result = result + current.value.toString();
			}
			current = current.next;
		}
		result += " ]";
		return result;
	}

	private class Header<T> {
		Node<T> head;
		Node<T> tail;
	}

	private class Node<T> {
		Node<T> next;
		T value;

		Node(T t) {
			value = t;
		}
	}
}
