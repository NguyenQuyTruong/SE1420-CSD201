/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_1;

import java.util.ArrayList;

/**
 *
 * @author minhv
 */
public class Test {

    public static void main(String[] args) {
	DoublyLinkedList list = new DoublyLinkedList();
	User user1 = new User("123", 1);
	User user2 = new User("294", 2);
	User user3 = new User("345", 3);
	User user4 = new User("533", 4);
	User user5 = new User("341", 5);
	User user6 = new User("435", 6);
	User user7 = new User("325", 7);
	User user8 = new User("652", 8);
	User user9 = new User("342", 9);
	User user10 = new User("546", 10);

	list.addFirst(user1);
	list.addFirst(user3);
	list.addFirst(user5);
	list.addLast(user9);
	list.addLast(user6);
//	list.addBetweenNode(user10, );

	list.printlist(list);
	ArrayList<User>
    }
}