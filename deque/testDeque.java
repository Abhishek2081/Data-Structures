package deque;

public abstract class testDeque {

	public static void main(String[] args) {
		MyDeque<Integer> deque = new MyDeque<>();
		
		deque.addToHead(30);
		deque.addToHead(20);
		deque.addToHead(10);
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
		System.out.println(deque.removeLast());
	}
}
