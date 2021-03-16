package linkedlist;

public class testList {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<>();
		
		list.AddNode(10);
		list.AddNode(20);
		list.AddNode(30);
		list.printList();
	}

}
