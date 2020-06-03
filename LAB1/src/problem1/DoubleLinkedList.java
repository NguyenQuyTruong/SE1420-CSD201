package problem1;

import problem1.DoubleLinkedList.node;

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
	 
	 public node headNode, tailNode;
	 
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
		headNode = makeNode("", -1);
		tailNode = makeNode("", -1);
		
		headNode.right = tailNode;
		tailNode.left = headNode;
	}
	
	
}
