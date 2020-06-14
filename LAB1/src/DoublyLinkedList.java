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

        String email;    // mobile game need email
        long point;       // and point
             Node right, left;  // doubly linked list has Node left and right

        // Create an contructor for email, point of players with 2 default Node = null
        public Node(String emailSub, long pointSub) {
            this.email = emailSub;
            this.point = pointSub;
            right = left = null;
        }
    }
    /**
     * Create some Node to manage doubly linked list
     */
    public Node header;
    public Node trailer;
    private Node prevHeader;

    public DoublyLinkedList() {
        prevHeader = new Node(null, Integer.MIN_VALUE);
        trailer = new Node(null, Integer.MIN_VALUE);
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
        } // this situation: add First   (between prevHeader and header)
        else if (header.point < newNode.point) {

            newNode.right = header;
            header.left = newNode;
            newNode.left = prevHeader;
            prevHeader.right = newNode;

            header = newNode;
        } // this situation: add last (between trailer.left and trailer)
        else if (trailer.left.point > newNode.point) {

            Node tmp = trailer.left;

            newNode.right = trailer;
            trailer.left = newNode;
            newNode.left = tmp;
            tmp.right = newNode;
        } // this situation: add to the middle 
        else {
            Node tmp = header;
            while (tmp.point > newNode.point) {
                tmp = tmp.right;
            }
            Node save = tmp.left;

            save.right = newNode;
            newNode.left = save;
            tmp.left = newNode;
            newNode.right = tmp;
        }
    }

    /**
     * Remove the first Node
     */
    public void removeFirst() {
        Node headLeft = header.left;
        Node headRight = header.right;
        if (header == null) {
            return;
        } else {
            headLeft.right = headRight;
            headRight.left = headLeft;
            header = header.right;
        }
    }

    /**
     * Remove information of player by Email
     */
    public void remove(String email) {
        Node tmp = searchEmail(email);
        Node moveleft = tmp.left;
        Node moveright = tmp.right;
        // if header is null so don't do anything
        if (header == null) {
            return;
        }else {
            moveleft.right = moveright;
            moveright.left = moveleft;
            tmp = null;
        }

    }

    /**
     * Use to search email of player. other Functions can use this function.
     *
     * @param email
     * @return
     */
    public Node searchEmail(String tenEmail) {
        Node tmp = header;
        //If comparation of 2 emails don't match -> header will move right ..right..(loop...)
        while (!tmp.email.equalsIgnoreCase(tenEmail)) {
            tmp = tmp.right;
        }
        // When 2 email match each other -> return tmp (email found)
        return tmp;
    }
    

    /**
     * User search by email then return their point
     * @param email
     * @return 
     */
    public long getPointByEmail(String email){
        Node tmp = searchEmail(email);
        return tmp.point;
    }
    
    /**
     * Return a highest point
     * @return 
     */
    public long getFirstPoint(){
        return header.point;
    }
    
    /**
     * Update a new point base on Email
     * -Delete a Node by email
     * -Then add them again with a new email and new point
     * @param newEmail 
     */
    public void update(String newEmail, long newPoint){
        Node tmp = searchEmail(newEmail);
        if(tmp == trailer) return;
        else{
            remove(newEmail);
            add(newEmail, newPoint);
        }
    }
    /**
     * Print all node from left -> right
     */
    public void print() {
        if (header == null) {
            return;
        }
        System.out.println("Email," + " Point");
        for (Node n = prevHeader.right; n != trailer; n = n.right) {
            System.out.println(n.email + ", " + n.point);
        }
    }

}
