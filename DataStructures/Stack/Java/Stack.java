import java.util.List;
import java.util.ArrayList;

/**
 * @summary: simple implementation of a Stack of integers using ArrayLists as the
 *           underlying DS.
 * @author: Kayhan Dehghani
 **/
public class Stack {
	private List<Integer> stack;
	
	public Stack() {
		this.stack = new ArrayList<Integer>();
	}
	
	// it is up to the user to check if the stack is empty
	public int pop() {
		int topIndex = stack.size() - 1;
		int topElement = stack.get(topIndex);
		stack.remove(topIndex);
		return topElement;
	}
	
	public void push(int element) {
		stack.add(element);
	}
	
	public int peek() {
		return stack.get(stack.size() - 1);
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}
	
	public void print() {
		if (stack.isEmpty()) {
			System.out.println("Stack is empty!");
		} else {
			for (int element : stack) {
				System.out.print(element + "\t");
			}
		}
	}
}
