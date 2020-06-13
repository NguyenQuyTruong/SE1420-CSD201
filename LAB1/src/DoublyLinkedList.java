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

        private String emailSub;    // mobile game need email
        private long pointSub;       // and point
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
        else if (header.pointSub < newNode.pointSub) {

            newNode.right = header;
            header.left = newNode;
            newNode.left = prevHeader;
            prevHeader.right = newNode;

            header = newNode;
        } // this situation: add last (between trailer.left and trailer)
        else if (trailer.left.pointSub > newNode.pointSub) {

            Node tmp = trailer.left;

            newNode.right = trailer;
            trailer.left = newNode;
            newNode.left = tmp;
            tmp.right = newNode;
        } // this situation: add to the middle 
        else {
            Node tmp = header;
            while (tmp.pointSub > newNode.pointSub) {
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
        
        while (!tmp.emailSub.contentEquals(tenEmail)) {
            tmp = tmp.right;
        }
        return tmp;
    }
    

    /**
     * Use function searchEmail to return point
     * @param email
     * @return 
     */
    public long getPoint(String email){
        Node tmp = searchEmail(email);
        return tmp.pointSub;
    }
    
    public long getFirstPoint(){
        return header.pointSub;
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
            System.out.println(n.emailSub + ", " + n.pointSub);
        }
    }

}
