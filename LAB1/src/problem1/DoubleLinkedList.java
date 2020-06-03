package problem1;

public class DoubleLinkedList {
	 class node{
		node left = null;
		node right = null;
		private String email;
		private long point;
		
		public node(String email, long point) {
			this.email = email;
			this.point = point;
		}
		
		public long getPoint() {
			return point;
		}
		
		public String getEmail() {
			return email;
		}
	}
	 
	 node head;
	 
	 /**
	  * create new node with email, point
	  * @param email
	  * @param point
	  * @return new node
	  */
	public node makeNode(String email, long point) {
		node newNode = new node(email, point);
		return newNode;
	}
	
	
	/**
	 * DoubleLinkedList constructor, first we will set head to null (make sure) 
	 * 
	 */
	public DoubleLinkedList() {
		head = null; //init head is null
	}
	
	public node getHead() {
		return head;
	}
	
	public void setHead(node head) {
		this.head = head;
	}
	
}
