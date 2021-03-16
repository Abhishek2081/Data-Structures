package queue;

import linkedlist.MyLinkedList.Node;

public class MyQueue<E> {
	
	Node<E> head, rear;

	public MyQueue() {
		head = null;
		rear = null;
	}
	
	public void enqueue(E data)
	{
		if(head == null)
		{
			head = rear = new Node<>(data);
			return;
		}
		rear.next = new Node<>(data);
		rear = rear.next;
	}
	
	public E dequeue()
	{
		if(head == null)
			return null;
		Node<E> temp = head;
		head = head.next;
		if(head == null)
		{
			head = rear = null;
		}
		return temp.data;
	}

}
