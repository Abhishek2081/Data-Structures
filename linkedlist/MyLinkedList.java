package linkedlist;

public class MyLinkedList<E> {
	
	Node<E> head;
	
	public MyLinkedList() {
		head = null;
	}
	
	public void AddNode(E data)
	{
		Node<E> temp = head;
		if(isEmpty())
		{
			head = new Node<E>(data);
			return;
		}
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = new Node<E>(data);
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void printList()
	{
		Node<E> temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public E removeLast() throws Exception {
		Node<E> temp = head;
		
		if(temp == null)
			throw new Exception("Stack is Empty");
		
		if(temp.next == null)
		{
			head = null;
			return temp.data;		
		}
		while(temp.next.next != null)
		{
			temp = temp.next;
		}
		E dat = temp.next.data;
		temp.next = null;
		return dat;
	}
	
	public E getLast() throws Exception {
		Node <E> temp = head;
		
		if(temp == null)
			throw new Exception("Stack is Empty");
		
		while(temp.next != null)
		{
			temp = temp.next;
		}
		return temp.data;
	}
	
	public static class Node<E>
	{
		public E data;
		public Node<E> next;
		
		public Node(E data)
		{
			this.data = data;
			next = null;
		}
	}
}
