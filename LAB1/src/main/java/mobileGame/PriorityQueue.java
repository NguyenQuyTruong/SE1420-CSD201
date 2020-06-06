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
     * this method will add user to the queue and sort it depend on their point
     * from low to high
     *
     * @param data user
     */
    public void push(Gamer data) {
	list.add(data);
	System.out.println("push Gamer data successful!!");
    }
}
