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
    private class Node{ //node class
        int data ; //data user
        Node prev;
        Node next;
        
        public Node(int data, Node prev_node, Node next_node){
           this.data = data;
           this.prev = prev_node;
           this.next = next_node;
        }

        public Node() {
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
        
    }
}
