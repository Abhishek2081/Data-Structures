package stack;

import linkedlist.MyLinkedList;

public class MyStack<E> {

	private MyLinkedList<E> list1 = new MyLinkedList<>();

	public MyStack() {
		
	}
	
	void push (E data)
	{
		list1.AddNode(data);
	}
	
	E pop() throws Exception
	{
		return list1.removeLast();
	}
	
	E peek() throws Exception
	{
		return list1.getLast();
	}
	
	
}
