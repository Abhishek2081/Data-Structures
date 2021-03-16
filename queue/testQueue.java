 package queue;

public class testQueue {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(400);
		System.out.println(queue.dequeue());
	}

}
