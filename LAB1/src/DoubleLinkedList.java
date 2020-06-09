
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
        private int data;//user data
        private Node prev;//data head
        private Node next;//next data
      //constuctor
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
          //return true if DoubleLinkedList empty otherwise return false
        }
        
        public boolean isEmpty(){
          return head == null;
        //append a new node to the end of list
    }
        
        //insert a new node to the beginning of list
        public void addFirst(int z, Node font, Node back){
            Node p = new Node(z, font, back);
            if(isEmpty()){
                head = tail = p;
            }
            else{
                p.next = head; 
                head = p;
            }    
        }
        //append a new node to the end of list
        public void addLast(int y, Node font, Node back){
            Node p = new Node(y, font, back);
            if(isEmpty()){
                head = tail = p;
            }
            else{
                tail.next = p;
                tail = p;
            }
    }

        public int size(){
            return 0;
    }
        
        
}
