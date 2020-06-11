/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class singlyLinkedList {

    // create Node
    private class Node {

        private manageGamer gamer;
        private Node next;

        public Node() {
        }
        
        
        public Node(manageGamer gamer, Node next) {
            this.gamer = gamer;
            this.next = next;
        }

        public manageGamer getGamer() {
            return gamer;
        }

        public void setGamer(manageGamer gamer) {
            this.gamer = gamer;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
    }
    // head and and tail of node
    private Node head = null;
    private Node tail = null;
    private int size=0;
    
    // top, size
    
    public int size() {
        int result = 0;
        for (Node s = head; s != null; s = s.next) {
            result++;
        }
        return result;
    }

    public manageGamer getTop() {
        return head.gamer;
    }

    // check empty
    public boolean isEmpty() {
        return head == null;
    }

    // add element
    public void addFirst(manageGamer g) {
        head = new Node(g, head);
        tail = head.next == null ? head : tail;
    }

    public void addLast(manageGamer g) {
        Node newNode = new Node(g, null);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    //remove
    public manageGamer removeFirst() {
        manageGamer result = null;
        if (head != null) {
            result = head.gamer;
            head = head.next;
            tail = head == null ? null : tail;
        }
        return result;
    }
    public manageGamer font(){
        return head.gamer;
    }
   
    // out put on screen
    
}
