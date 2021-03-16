package deque;

public class MyDeque<E> {

	Node<E> head, tail;
	
	public void addToHead(E data)
	{
		if(head == null)
		{
			head = tail = new Node<>(data);
			return;
		}
		Node<E> p = new Node<>(data);
		tail.next = p;
		p.prev = tail;
		tail = tail.next;
	}
	
	public E removeLast()
	{
		if(head == null)
			return null;
		Node p = tail;
		tail = tail.prev;
		if(tail == null)
			head = tail = null;
		else
			tail.next = null;
		return (E) p.data;
	}
			
	public static class Node<E>
	{
		E data;
		Node<E> next, prev;
		
		public Node(E data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}
}
