package problem1;

public class DoubleLinkedList {
	 class node{
		node left = null;
		node right = null;
		String email;
		long point;
		
		public node(String email, long point) {
			this.email = email;
			this.point = point;
		}
	}
	 
	 /**
	  * create new node with email, point
	  * @param email
	  * @param point
	  * @return new node
	  */
	private node makeNode(String email, long point) {
		node newNode = new node(email, point);
		return newNode;
	}
	
	node head;
	/**
	 * DoubleLinkedList constructor, first we will set head to null (make sure) 
	 * 
	 */
	public DoubleLinkedList() {
		head = null; //init head is null
	}
	
	public void insert(String email, long point) {
		
	}
}
