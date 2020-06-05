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
public class testList {
    public static void main(String[] args) {
	DoubleLinkedList list = new DoubleLinkedList();
	Gamer g1 = new Gamer("AS", 100);
	Gamer g2 = new Gamer("BC", 150);
	Gamer g3 = new Gamer("CD", 200);
	Gamer g8 = new Gamer("PL", 320);
	Gamer g7 = new Gamer("LOL", 280);

	list.addFirst(g1);
	list.addFirst(g2);
	list.addFirst(g3);
	list.addLast(g8);
	list.addLast(g7);
	list.printList(list);
    }
}
