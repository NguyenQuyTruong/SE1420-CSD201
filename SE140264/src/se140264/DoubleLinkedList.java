/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se140264;

/**
 *
 * @author ACER
 */
public class DoubleLinkedList {
    class node {
        String Name;
        int point;
        node pre, next;

        public node(String Name, int point) {
            this.Name = Name;
            this.point = point;
            pre = next = null;
        }
        
   }
    public node head, hideHead, tail;
    
    public DoubleLinkedList(){
        node newNode = new node(null, 0);
        hideHead = newNode;
        tail = newNode;
        
    }
    public void print(){
        for (node i = hideHead.next; i != tail; i = i.next) {
            System.out.println("Name: "+ i.Name + "// point: "+ i.point);
            
        }
    }
    
    
    
}
