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

    class Node {

        private String email;
        private int point;
        Node left, right;

        public Node(String email, int point) {
            this.email = email;
            this.point = point;
            left = right = null;
        }
    }
    public Node head;
    private Node pre_Head;
    private Node trailer;

    public DoublyLinkedList() {
        pre_Head = new Node(null, -1);
        trailer = new Node(null, -1);
    }
}
