/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Chi  Cuong
 */
public class DoublyLinkedList {

    // Create a class Node include information's gamer with 2 Node right, left 
    public class Node {

        private String emailSub; // to link this emailSub -> email (InfoGamer.java)
        private long pointSub;       // and this pointSub -> point (InfoGamer.java)
        private Node right, left;  // doubly linked list has Node left and right

        // Create an contructor for email, point of players with 2 default Node = null
        public Node(String emailSub, long pointSub) {
            this.emailSub = emailSub;
            this.pointSub = pointSub;
            right = left = null;
        }
    }
    /**
     * Create some Node to manage doubly linked list
     */
    private Node header;
    private Node trailer;
    private Node prevHeader;

    public DoublyLinkedList() {
        prevHeader = new Node(null, Integer.MIN_VALUE);
        trailer = new Node(null, -1);
    }

    /**
     * Insert email, point Insert with some situation
     *
     * @param email
     * @param point
     */
    public void add(String email, long point) {
        Node newNode = new Node(email, point);
        // this situation : list is empty
        if (header == null) {
            newNode.right = trailer;
            trailer.left = newNode;
            newNode.left = prevHeader;
            prevHeader.right = newNode;
            header = newNode;
            // this situation: add First   
        } else if (header.pointSub < newNode.pointSub) {

            newNode.right = header;
            header.left = newNode;
            newNode.left = prevHeader;
            prevHeader.right = newNode;

            header = newNode;
            // this situation: add last
        } else if (trailer.left.pointSub > newNode.pointSub) {

            Node tmp=trailer.left;
            
            newNode.right = trailer;
            trailer.left = newNode;
            newNode.left = tmp;
            tmp.right=newNode;

        }
    }

    /**
     * Print all node from left -> right
     */
    public void print() {
        if (header == null) {
            return;
        }
        System.out.println("Email" + "\tPoint");
        for (Node n = prevHeader.right; n != trailer; n = n.right) {
            System.out.println("" + n.emailSub + "\t" + n.pointSub);
        }
    }

}
