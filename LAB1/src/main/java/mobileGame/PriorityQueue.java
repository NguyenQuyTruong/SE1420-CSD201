/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

/**
 *
 * @author nhoxr
 */
public class PriorityQueue {

    private DoubleLinkedList list = new DoubleLinkedList();

    /**
     * this method will add user to the queue
     *
     * @param data user
     */
    public void push(Gamer data) {
	list.add(data);
	System.out.println("push Gamer data successful!!");
    }

    /**
     * this method will get the top Gamer of the list depend on his point
     *
     * @return top Gamer
     */
    public Gamer getTop() {
	return list.first();
    }

    /**
     * this method will delete top Gamer of the list
     */
    public void deleteTop() {
	list.removeFirst();
    }
}
