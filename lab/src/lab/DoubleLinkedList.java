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
    Node head,tail;
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
        
        Node(int d) {
            data = d;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if(head == null){
            head.prev = newNode;
        }
        head = newNode;
    }
}

