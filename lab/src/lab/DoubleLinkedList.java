/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Khả Thi
 */
public class DoubleLinkedList {
    public Node head,tail;

    public DoubleLinkedList(Node head, Node tail) {
        head = Push("", 1);
        tail = Push("", 1);
        head.prev = tail;
        tail.next = head;
    }
    public DoubleLinkedList(){
        
    }
    class Node{
        int data;
        Node prev = null;
        Node next = null;
        private String email;
        private long point;

        public Node(String email, long point) {
            this.email = email;
            this.point = point;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public long getPoint() {
            return point;
        }

        public void setPoint(long point) {
            this.point = point;
        }
    }
    public Node Push(String email, long point){
        Node newNode = new Node(email, point);
        return newNode;
    }
    public boolean IsEmpty(){
        return (head.prev == tail);
    }

}

