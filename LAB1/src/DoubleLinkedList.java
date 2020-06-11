/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DoubleLinkedList {

    private class Node {

        private int point;
        private String email;
        private Node right;
        private Node left;

        public Node(int point, String email) {
            this.point = point;
            this.email = email;
            left =right=null;
        }
    }
    
    public Node header;
    private Node pre_header;
    public Node tailer;
    
    public void DoubleLinkedList(){
        Node newNode = new Node(-1,null);//ban dau point va email chua co se la -1 va null
        pre_header = newNode;
        tailer = new Node(-1,null);
    }
    
    
  
}
