// 3-1-23
public class Stack {
	private Node head;
	
	public Stack() {
		head = null;
	}
	
	public void setHead(Node node) {
		head = node;
	}
	
	public void push(Node node) {
		node.setNext(head.getNext());
		setHead(node);
	}
	
	public int pop() {
		int outValue = head.getValue();
		head.setNext(head.getNext());
		return outValue;
	}

}
