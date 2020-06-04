package problem1;

import java.io.Serializable;

import problem1.DoubleLinkedList.node;

public class PriorityQueue implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	DoubleLinkedList list = new DoubleLinkedList();
	
	/**
	 * Insert into priority queue, look simple but it doesn't!!!
	 * @param email
	 * @param point
	 */
	public void insert(String email, long point) {
		node newNode = list.makeNode(email, point);
		
		if (list.headNode.right == list.tailNode) { 
			//if head link to tail ==> queue empty ==> insert center between HEAD and TAIL
			list.headNode.right = newNode;
			newNode.left = list.headNode;
			newNode.right = list.tailNode;
			list.tailNode.left = newNode;
		}else{
			
			if (newNode.getPoint() < list.tailNode.left.getPoint()) { 
				//if the tail node value bigger than newNode, break the link and set new tail
				list.tailNode.left.right = newNode;
				newNode.left = list.tailNode.left;
				newNode.right = list.tailNode;
				list.tailNode.left = newNode;
			}
			else if (newNode.getPoint() > list.headNode.right.getPoint()) {
				//if the head node value smaller than newNode, break the link and set new head
				list.headNode.right.left = newNode;
				newNode.right = list.headNode.right;
				newNode.left = list.headNode;
				list.headNode.right = newNode;
			}
			else {
				//normal case, looping though
				node currentNode = list.headNode.right;
				while(currentNode.getPoint() > newNode.getPoint()) {
					currentNode = currentNode.right;
				}
				newNode.right = currentNode;
				newNode.left = currentNode.left;
				currentNode.left.right = newNode;
				currentNode.left = newNode;
			}
			
		}
		
	}
	

	public void printAll() {
		node currentNode = list.headNode;
		while(currentNode.right != null) {
			if (currentNode != list.headNode) {
				System.out.print(currentNode.getPoint() + "  ");	
			}
			currentNode = currentNode.right;
		}
	}
}
