package stack;

public class testStack {

	public static void main(String args[]) throws Exception {
		MyStack<Integer> stack = new MyStack<>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());		
		System.out.println(stack.pop());
	}
}
