/**
 * @summary: simple implementation of a Queue of integers using Singly-Linked List with access to head and tail
 *           as the underlying DS.
 * @author: Kayhan Dehghani
 **/
public class Queue {
	private static sLinkedList queue = new sLinkedList();

	public void enqueue(int element) {
		queue.addToTail(element);
	}
	
	public int dequeue() throws IllegalAccessException {
		return queue.removeFromHead();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public int getSize() {
		return queue.getSize();
	}

	// returns the next element waiting to be dequeued	
	public int peek() throws IllegalAccessException {
		return queue.getHead(); 
	}
	
	// prints the elements where the most recently added element is to left of the list
	public String toString() {
		return queue.toString();
	}
	
	static class sLinkedList {
		private static Header header = new Header();
		private static int size;

		boolean isEmpty() {
			return header.getHead() == null && header.getTail() == null && size == 0;
		}

		int getSize() {
			return size;
		}

		void addToTail(int element) {
			IntNode newNode = new IntNode(element, null);
			if(this.isEmpty()) {
				header.setHead(newNode);
			} else {
				header.getTail().setNext(newNode); 
			}
			header.setTail(newNode);
			size++;
		}

		int removeFromHead() throws IllegalAccessException {
			if(!this.isEmpty()) {
				IntNode oldHead = header.getHead();
				if(oldHead.getNext() == null) { // stack has one element
					header.setTail(null);    
				} 
				header.setHead(oldHead.getNext());
				size--;
				return oldHead.getVal();
			} else {
				throw new IllegalAccessException("Empty queue!");
			}
		}

		int getHead() throws IllegalAccessException {
			if(!this.isEmpty()) {
				return header.getHead().getVal();
			} else {
				throw new IllegalAccessException("Empty queue!");
			}
		}

		public String toString() {
			String string = "[ ]";
			if(!this.isEmpty()) {
				IntNode currentNode = queue.header.getHead();
				string = "[ " + currentNode.getVal();
				currentNode = currentNode.getNext();
				while(currentNode != null) {
					string += String.format(", " + currentNode.getVal());
					currentNode = currentNode.getNext();
				}
				string += " ]";
			}
			return string;
		}

		class IntNode {
			private int value;
			private IntNode next;
			
			IntNode(int value, IntNode next) {
				this.value = value;
				this.next = next;
			}

			void setNext(IntNode next) {
				this.next = next;
			}

			IntNode getNext() {
				return next;
			}

			int getVal() {
				return value;
			}
		}

		static class Header {
			private IntNode head;
			private IntNode tail;

			void setTail(IntNode tail) {
				this.tail = tail;
			}

			void setHead(IntNode head) {
				this.head = head;
			}

			IntNode getTail() {
				return tail;
			}

			IntNode getHead() {
				return head;
			}
		}
	}
}
