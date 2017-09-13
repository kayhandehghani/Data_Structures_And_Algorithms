public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		System.out.println(pq);
		
		pq.insert("food", 9);
		pq.insert("sleep", 10);
		pq.insert("car", 8);
		pq.insert("programming", 7);
		pq.insert("happiness", 100);
		pq.insert("peace of mind", 200);
		pq.insert("money", 2);
		pq.insert("music", 9);

		System.out.println(pq);
		System.out.println(pq.size());
		
		System.out.println(pq.removeMax());
		System.out.println(pq.removeMax());
		
		System.out.println(pq.size());
		System.out.println(pq);
		try {
			System.out.println(pq.peek());
		} catch (Exception e) {
			System.out.println("peek correctly threw exception for empty queue.");
		}
		System.out.println(pq.removeMax());
		System.out.println(pq);
		System.out.println(pq.removeMax());
		System.out.println(pq.removeMax());
		pq.clear();
		try {
			System.out.println(pq.peek());
		} catch (Exception e) {
			System.out.println("peek correctly threw exception for empty queue.");
		}
	}
}
