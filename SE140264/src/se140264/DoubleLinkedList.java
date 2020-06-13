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
    public void add(String Name, int point){
        node newNode = new node(Name, point);
        if (head == null)
        {
            head = newNode;
            head.pre = hideHead;
            hideHead.next = head;
            head.next = tail;
            tail.pre = head;
        } else if (newNode.point > head.point){
            newNode.next = head;
            head.pre = newNode;
            newNode.pre = hideHead;
            hideHead.next = newNode;
            head = newNode;
        } else if (newNode.point < tail.pre.point){
            node testing = tail.pre;
            newNode.next = tail;
            tail.pre = newNode;
            newNode.pre = testing;
            testing.next = newNode;
        } else {
            node tesing = head;
            while (tesing.point > newNode.point){
                tesing= tesing.next;
            }
            node preTesting = tesing.pre;
            newNode.next= tesing;
            tesing.pre = newNode;
            newNode.pre = preTesting;
            preTesting.next = newNode;
        }
    }
    
    public void remove (String Name){
        
        node testing = head;
        while(!(testing.Name.contentEquals(Name)) && testing != tail){
            testing= testing.next;
        }
        
        if (testing == tail){
            System.out.println("Name not found!");
        }else {
            testing.pre.next = testing.next;
            testing.next.pre = testing.pre;
            testing = null;
            System.out.println("Remove succes!");
        }
        
    }
    
    public void removeTop(){
        hideHead.next = head.next;
        head.next.pre = hideHead;
        head = head.next;
        
    }
    
    public int gettop(){
        return head.point;
    }
    
    public void update(String Name , int point){
        node testing = head;
        while(!(testing.Name.contentEquals(Name)) && testing != tail){
            testing= testing.next;
        }
        if (testing == tail){
            System.out.println("Name not found!");
        }else {
            testing.point = point;
        }
    }
    
    
}
