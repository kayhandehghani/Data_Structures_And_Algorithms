import java.util.ArrayList;
public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList<String>();
		System.out.println(ll.isEmpty());
		ll.insert("first");
		System.out.println(ll.getHead());
		System.out.println(ll.getTail());
		ll.insert("second");
		System.out.println(ll.getHead());
		System.out.println(ll.getTail());
		ll.insert("third");
		ll.insert(9);
		System.out.println(ll.getHead());
		System.out.println(ll.getTail());
		System.out.println(ll.isEmpty());
		System.out.println(ll); 
		System.out.println(ll.deleteNode("second")); // returns true
		System.out.println(ll); // second is removed
		System.out.println(ll.deleteNode("first")); // returns true
		System.out.println(ll); // only has third
		System.out.println(ll.deleteNode("not valid")); // returns false
		System.out.println(ll.deleteNode("third")); // returns true
		System.out.println(ll.deleteNode(9)); // returns true
		System.out.println(ll); // empty
		System.out.println(ll.deleteNode("third")); // returns false
		
		
		System.out.println(ll.getHead()); // returns null
		System.out.println(ll.getTail()); // returns null
		ll.insert(new int[]{1, 2, 2, 7});
		System.out.println(ll.isEmpty()); // returns false
		System.out.println(ll); // object reference (toString method of Array returns that!)
		ArrayList t = new ArrayList<>();
		t.add(1);
		t.add("second in arraylist");
		ll.insert(t);
		System.out.println(ll.isEmpty()); // returns false
		System.out.println(ll); // object reference (toString method of Array returns that!)
		ll.insert(9);
		ll.insert("another");
		ll.insert(9);
		ll.insert(-88.1212);
		ll.insert(9);
		ll.insert("another");
		ll.insert("another");
		ll.insert("another");
		ll.insert(9);
		ll.insert(9);
		ArrayList t2 = new ArrayList<>();
		t2.add(1);
		t2.add("second in arraylist");
		ll.insert(t2);
		System.out.println(ll);
		ll.deleteAllNodes(9);
		ll.deleteAllNodes("another");
		ll.deleteAllNodes(t2);
		System.out.println(ll);
		ll.clear();
		System.out.println(ll); // empty
		ll.insert(9);
		ll.insert("another");
		ll.insert(9);
		ll.insert(-88.1212);
		ll.insert(9);
		ll.insert("another");
		ll.insert("another");
		ll.insert("another");
		ll.insert(9);
		ll.insert(9);
		System.out.println(ll); 
		ll.removeDuplicates();
		System.out.println(ll); // only one "another" and one 9
		ll.insert(-88.1212);
		ll.insert(-88.1212);
		ll.insert(8);
		ll.insert(-88.1212);
		ll.insert(-88.1212);
		ll.insert(7);
		ll.insert(9);
		ll.insert(-88.1212);
		ll.insert(-88.1212);
		System.out.println(ll); 
		System.out.println(ll.nthToLast(50)); // null
		System.out.println(ll.nthToLast(0)); // null
		System.out.println(ll.nthToLast(1)); // -88.1212
		System.out.println(ll.nthToLast(2)); // -88.1212
		System.out.println(ll.nthToLast(3)); // 9
		System.out.println(ll.nthToLast(4)); // 7
		System.out.println(ll.nthToLast(12)); // 9
		System.out.println(ll.nthToLast(13)); // null
		ll.removeDuplicates();
		System.out.println(ll); 

	}
}
