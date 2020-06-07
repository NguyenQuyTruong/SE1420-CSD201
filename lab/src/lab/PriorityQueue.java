/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import lab.DoubleLinkedList.Node;

/**
 *
 * @author Khả Thi
 */

public class PriorityQueue {
    DoubleLinkedList dll = new DoubleLinkedList();
    
    public void InSert(String email, long point){
        Node new_node  = dll.Push(email, point);
        if(dll.IsEmpty()){
            dll.head.prev = new_node;
            new_node.next = dll.head;
            new_node.prev = dll.tail;
            dll.tail.next = new_node;
        }
        else{
            if (new_node.getPoint() < dll.tail.next.getPoint()) { 
				dll.tail.next.prev = new_node;
				new_node.next = dll.tail.next;
				new_node.prev = dll.tail;
				dll.tail.next = new_node;
			}
			else if (new_node.getPoint() > dll.head.prev.getPoint()) {

			}
			else {
				//normal case, looping though
				Node currentNode = dll.head.prev;
				while(currentNode.getPoint() > new_node.getPoint()) {
					currentNode = currentNode.prev;
				}
				new_node.prev = currentNode;
				new_node.next = currentNode.next;
				currentNode.next.prev = new_node;
				currentNode.next = new_node;
			}
        }
   
    }
}
