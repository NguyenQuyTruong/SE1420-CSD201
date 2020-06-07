/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import lab.DoubleLinkedList.Node;

/**
 *
 * @author Khả Thi
 */

public class PriorityQueue {
    DoubleLinkedList dll = new DoubleLinkedList();
    
    public void InSert(String email, long point){
        Node new_node  = dll.Push(email, point);
        if(dll.IsEmpty()){
            dll.head.prev = new_node;
            new_node.next = dll.head;
            new_node.prev = dll.tail;
            dll.tail.next = new_node;
        }
        else{
            if (new_node.getPoint() < dll.tail.next.getPoint()) { 
				dll.tail.next.prev = new_node;
				new_node.next = dll.tail.next;
				new_node.prev = dll.tail;
				dll.tail.next = new_node;
			}
			else if (new_node.getPoint() > dll.head.prev.getPoint()) {
                                dll.head.prev.next = new_node;
				new_node.prev = dll.head.prev;
				new_node.next = dll.head;
				dll.head.prev = new_node;
			}
			else {
				Node currentNode = dll.head.prev;
				while(currentNode.getPoint() > new_node.getPoint()) {
					currentNode = currentNode.prev;
				}
				new_node.prev = currentNode;
				new_node.next = currentNode.next;
				currentNode.next.prev = new_node;
				currentNode.next = new_node;
			}
        }
   
    }
    public Node Find(String fmail){
        Node fnode = dll.head.prev;
        while(fnode.getEmail().contentEquals(fmail) && fnode != dll.tail){
            fnode = fnode.prev;
        }
        return fnode;
    }
    public void Delete(String demail){
        Node dnode = Find(demail);
        if(dnode != dll.tail){
            System.out.println("Don't exit!");
        }
        else{
            dnode.next.prev = dnode.prev;
            dnode.prev.next = dnode.next;
            dnode = null;
        }
    }
    public void Update(String uEmail, long Newpoint){
        Node uNode = dll.Push(uEmail, Newpoint);
        if(uNode != dll.tail){
            System.out.println("Don't exit!");
        }
        else{
            uNode.setPoint(Newpoint);          
        }
    }
    public long GetP(String email){
        Node gNode = Find(email);
        if(gNode != dll.tail){
            return gNode.getPoint();
        }
        return 0;
    }
    public void Gettop(){
    if(dll.IsEmpty()){
        System.out.println("List empty!");
    }
    else{
        System.out.println("Top:"+dll.head.prev.getEmail()+" "+dll.head.prev.getPoint()+"P");
    }
}
    public void DeleteT(){
        if(dll.IsEmpty()){
            System.out.println("List empty!");
        }
        else{
            Node n = dll.head.prev;
            n.next.prev = n.prev;
            n.prev.next = n.next;
            n = null;
        }
    }
}
