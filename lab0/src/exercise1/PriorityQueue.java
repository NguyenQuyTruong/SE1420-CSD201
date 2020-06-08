/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;



/**
 *
 * @author PC
 */
public class PriorityQueue {
    
    private DoublyLinkedList<Gamer> list = new DoublyLinkedList<>();

    public void insert(Gamer g) {
        //list is decrease
        //if list is empty, insert between head and tail
        if (list.isEmpty()) {
            list.addFirst(g);
        }

        //if new point<tail point then add new point in last
        if (g.point < list.trailer.getPrev().getElement().getPoint()) {
            list.addLast(g);
        }
        //if new point>head point then add new point in front
        if (g.point > list.header.next.getElement().getPoint()) {
            list.addFirst(g);
        }
        //normal case
        Node<Gamer>node;
        if(g.point>list.trailer.prev.getElement().getPoint() && g.point <list.header.next.getElement().getPoint())
        {   node=list.header.getNext();
        while(node.getElement().getPoint()>g.getPoint()){
            node=node.getNext();
        }
        list.addBetween(g, node.getPrev(), node);
                }
    }

}
