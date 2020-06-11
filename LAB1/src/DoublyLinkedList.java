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
    private class Node {

        InfoGamer info = new InfoGamer(); // new object "info" from InfoGamer.java
        private String emailSub = info.getEmail(); // to link this emailSub -> email (InfoGamer.java)
        private long pointSub = info.getPoint();       // and this pointSub -> point (InfoGamer.java)
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
    
    
    
    
   

}
