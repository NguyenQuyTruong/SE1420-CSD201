/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liemn
 */
public class DoubleLinkList {
    private class Node{
        String email;
        int point;
        Node left,right;
       
         Node(String email,int point) {
            this.email=email;
            this.point=point;
            left=right=null;
        }
    }
    private Node head;
    private Node pre_head;
    private Node tail;
        public DoubleLinkList(){
            Node newNode = new Node(null, 0);
            pre_head = newNode;
            tail = new Node(null, 0);
        }
        public void insert(String email,int point){
            Node newNode = new Node(email, point);
            
        }
        
}

