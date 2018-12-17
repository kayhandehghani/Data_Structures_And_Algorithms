public class QueueTest {

	public static void main(String[] args) {
		Queue queue = new Queue();
		System.out.println(queue);
		try {
			queue.dequeue();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(queue.isEmpty());
		System.out.println(queue.getSize());
		queue.enqueue(80);
		queue.enqueue(890);
		queue.enqueue(-9);
		System.out.println(queue.getSize());
		try {
			System.out.println(queue.peek());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(queue);
		System.out.println(queue);
		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.getSize() + "\t" + queue.dequeue() + "\t" + queue.getSize());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println(queue.isEmpty());

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}

		while (!queue.isEmpty()) {
			try {
				System.out.println(queue.getSize() + "\t" + queue.dequeue() + "\t" + queue.getSize() + "\t" + queue.isEmpty());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(queue);
	}
}
