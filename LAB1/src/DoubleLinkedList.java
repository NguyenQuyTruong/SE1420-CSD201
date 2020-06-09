
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
public class DoubleLinkedList{
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
        public void addFirst(int y, Node font, Node back){
            Node p = new Node(y, font, back);
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
        //gamer output list
        public void gamer(){
            Node p = head;
            while(p != null){
                System.out.print(p.data + " ");
                p = p.next;
                System.out.println("");
            }
        }
        //return a node at position m
        public Node get(int m){
            Node p = head;
            int c = 0;
            while(p != null && c < m){
                c++; p = p.next;
            }
            return p;
        }
        //return number of node in the list
        public int last(){
            Node p = head; 
            int c = 0;
            while(p != null){
                c++; p = p.next;
            }
            return c;
        }
        
        public void delete(Node q){
            Node f,p; f=null;p=head;
            while(p != null){
                if(p == q) break;
                f = p;
                p = p.next;
        }
            if(p == null) return;
            if(f == null){
                head = head.next;
                if(head == null) tail = null;
                    return;
   }
            f.next = p.next;
            if(f.next == null) tail = f;
 }
            
        //remove the node from the list
        public void remove(Node p){
            if(p == null) return;
            Node f = head, q = null;
            //find q where q.next = p
            while(f != null && f != p){
                q = f; 
                f = f.next;
                //remove head
                if(q == null){
                    head = head.next;
                    if(head == null) tail = null;
                }
                else{
                    q.next = p.next;
                    if(p == tail) tail = q;
                }
                p.next = null;
            }
        }
        
}
