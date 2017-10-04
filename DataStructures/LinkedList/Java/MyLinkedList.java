import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Iterator;
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

		Map<T, Node<T>> uniqPairs = new LinkedHashMap<>(); // to preseve the order
		Node<T> currentNode = header.head;

		while(currentNode != null) { // store unique values in the Map
			uniqPairs.put(currentNode.value, currentNode);
			currentNode = currentNode.next;
		}
		
		// build the new LinkedList from unique values
		Collection<Node<T>> uniqVals = uniqPairs.values(); 
		Iterator<Node<T>> it = uniqVals.iterator();
		size = uniqVals.size(); 
		header.head = it.next(); // starting point
		currentNode = header.head; 

		while(it.hasNext()) {
			currentNode.next = it.next();
			currentNode = currentNode.next;
		}
		
		header.tail = currentNode;
		header.tail.next = null;
	}

	public Node getTail() {
		return header.tail;
	}

	public Node getHead() {
		return header.head;
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

	class Header<T> {
		Node<T> head;
		Node<T> tail;
	}

	class Node<T> {
		Node<T> next;
		T value;

		Node() {
			value = null;
		}

		Node(T t) {
			value = t;
		}
	}
}
