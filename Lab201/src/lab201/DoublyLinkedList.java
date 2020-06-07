/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab201;

/**
 *
 * @author nds72
 */
public class DoublyLinkedList {

    /**
     * Create node base DoublyLinkedList Using modifier private to hide detail
     * user info
     *
     */

    private class Node {

        User data;
        Node next;
        Node prev;

        /**
         * create constructor of Node using alt insert to create quickly
         */
        public Node(User data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        //functions getter setter for data next prev
        
        public void setData(User data){
            this.data=data;
        }
        public void setNext(Node next){
            this.next=next;
        }
        public void setPre(Node prev){
            this.prev=prev;
        }
        

    }
}
