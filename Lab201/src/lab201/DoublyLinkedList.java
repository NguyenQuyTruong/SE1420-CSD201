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
     * create class Node using double linked list
     */
    class Node {

        private String email;
        private int point;
        Node left, right;

        /**
         * constructor of Node
         *
         * @param email
         * @param point
         */
        public Node(String email, int point) {
            this.email = email;
            this.point = point;
            left = right = null;
        }
    }
    /**
     * create Node head previous Head and trailer
     */
    public Node head;
    private Node pre_Head;
    private Node trailer;

    /**
     * using constructor default for preHead and trailer
     */
    public DoublyLinkedList() {
        pre_Head = new Node(null, -1);
        trailer = new Node(null, -1);
    }

    public void print(){
        for(Node n=pre_Head.right;n!=trailer;n=n.right){
            System.out.println(n.email+n.point);
        }
    }
    /**
     * 
     * @param email
     * @param point 
     */
    public void insert(String email, int point) {
        Node node = new Node(email, point);
        if (head == null) {
            head = node;
            head.left = pre_Head;
            pre_Head.right = head;
            head.right = trailer;
            trailer.left = head;
        } else if (node.point > head.point) {
            pre_Head.right = node;
            node.left = pre_Head;
            node.right = head;
            head.left = node;
            head=node;
        }else if(node.point<trailer.left.point){
            
            node.right=trailer;
            trailer.left=node;
            node.left=trailer.left;
            trailer.left.right=node;
        }
    }
}
