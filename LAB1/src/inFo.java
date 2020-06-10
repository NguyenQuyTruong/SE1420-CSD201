/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class inFo {

    private class Node {

        private int point;
        private String email;
        private Node next;
        private Node prev;

        public Node(int point, String email, Node next_node, Node prev_node) {
            this.point = point;
            this.email = email;
            this.next = next_node;
            this.prev = prev_node;
        }
    }
    
    
    
}
