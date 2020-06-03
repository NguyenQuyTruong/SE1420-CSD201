package problem1;

import problem1.DoubleLinkedList.node;

public class PriorityQueue {
	DoubleLinkedList list = new DoubleLinkedList();
	
	
	
	public void insert(String email, long point) {
		node newNode = list.makeNode(email, point);
		
		if (list.getHead() == null) {
			list.setHead(newNode);
		}else {
			node currentNode = list.getHead();
		}
	}
}
