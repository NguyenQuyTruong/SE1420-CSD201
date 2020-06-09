
import javax.xml.soap.Node;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class DoubleLinkedList {
    private class Node{
        private int data;
        private Node prev;
        private Node next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
}
    
    private Node head;
    private Node tail;
        public DoubleLinkedList(){
          head = tail = null;
        }
        
        public boolean isEmpty(){
          return head == null;
        //append a new node to the end of list
    }
        
        public void insert(int x, Node font, Node back){
            Node node = new Node(x, font, back);
            font.next = node;
            back.prev = node;
        }
        
        public void addFirst(int z){
            insert(z, head.next, head);
        }
        public void addLast(int y){
            insert(y, tail.prev, tail);
            
    }

        public int size(){
            return 0;
    }
}
