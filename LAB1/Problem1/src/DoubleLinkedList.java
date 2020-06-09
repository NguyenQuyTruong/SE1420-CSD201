/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class DoubleLinkedList {
    /**
    * Create an node of using doubly linkedlist
    *
    * @param <User>
    */
    private class Node{
        private User data;
        private Node next;
        private Node pre;

        /**
	 * Create constructor
	 *
	 * @param data
	 * @param next
	 * @param prev
	 */
        public Node(User data, Node next, Node pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
        
    }
    
    private Node header;
    private Node trailer;
    
    /**
     * Constructs a new empty list.
     */
    public DoubleLinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null, null, header);
        header.next = trailer;
    }
    
    /**
     * Add new node
     *
     * @param data
     * @param nextNode
     * @param prevNode
     */
    private void insert(User data, Node front, Node back){
        Node n = new Node(data, back, front);
        front.next = n;
        back.pre = n;
    }   
    
    public void addFirst(User data){
        insert(data, header, header.next);
    }
    
    public void addLast(User data){
        insert(data, trailer.pre, trailer);
    }
    
    private Node remove(Node n){
        if(n != header && n!= trailer){
            Node front = n.pre;
            Node back = n.next;
            front.next = back;
            back.pre = front;
        }
        return n;
    }
    
    
}