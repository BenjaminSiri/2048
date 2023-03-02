// 3-1-23
public class Stack {
	private Node head;
	
	public Stack() {
		head = null;
	}
	
	public void setHead(Node node) {
		head = node;
	}
	
	public void push(int value) {
		Node newNode = new Node(value);
		newNode.setNext(head.getNext());
		setHead(newNode);
	}
	
	public int pop() {
		int outValue = head.getValue();
		head.setNext(head.getNext());
		return outValue;
	}
	
	public int peek() {
		return head.getValue();
	}
	
	public boolean empty() {
		if(head == null) {
			return true;
		}
		return false;
	}

}
