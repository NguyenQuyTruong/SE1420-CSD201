/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KHAM
 */
public class MyQueue {

    private class Node {

        private Entry user;
        private Node next;

        public Node(Entry userInfo) {
            this.user = userInfo;
        }

        public Node() {
        }

        public Entry getUser() {
            return user;
        }

        public void setUser(Entry user) {
            this.user = user;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
    private Node head = null;
    private Node tail = null;
    
    public void enqueue(Entry user){
        Node newNode = new Node(user);
        if(isEmpty()){
            head = newNode;
        }
        if(tail != null && (user.getPoint() > head.user.getPoint())){
            tail = head;
            head = newNode;
            
        }
    }
    
    public void dequeue(){
        Entry firstUser = head.user;
        head = head.next;
        if(head == null){
            tail = null;
        }
    }
    
    public Entry front(){
        return head.user;
    }
    
    
    public boolean isEmpty(){
        return head == null;
    }
    
}
