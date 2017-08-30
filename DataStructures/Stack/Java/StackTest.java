public class StackTest {

	public static void main(String[] args) {
		Stack mystack = new Stack();
		mystack.print(); // empty
		
		System.out.println(mystack.isEmpty());
		mystack.push(-2);
		mystack.push(1);
		mystack.push(4);
		mystack.push(4);
		System.out.println(mystack.isEmpty());
		System.out.println(mystack.pop());
		mystack.push(44);
		mystack.push(55);
		mystack.push(552);
		System.out.println(mystack.peek());
		System.out.println(mystack.pop());
		System.out.println(mystack.peek());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.isEmpty());
		System.out.println(mystack.pop());
		System.out.println(mystack.isEmpty());
		
		mystack.print();  // empty
	}
}
