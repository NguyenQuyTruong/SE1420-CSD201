/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_1;

/**
 *
 * @author minhv
 * @param <User>
 */
public class DoublyLinkedList <User>{
    private class Node<User> {
	User data;
	Node<User> next;
	Node<User> prev;

	public Node(User data, Node<User> next, Node<User> prev) {
	    this.data = data;
	    this.next = next;
	    this.prev = prev;
	}
	
	
    }
}
