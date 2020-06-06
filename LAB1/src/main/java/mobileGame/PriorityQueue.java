/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.util.Scanner;

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

    public void deleteGamer() {
	Gamer data = inputMailForSearchGamer();
	if (data == null) {
	    System.out.println("Not fount");
	} else {

	}
    }

    /**
     * this method will receive email input and print the Gamer info.
     */
    public void searchGamer() {
	Gamer data = inputMailForSearchGamer();
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Email: " + data.getEmail() + ", Point: " + data.getPoint());
	}
    }

    /**
     * this method use to update Gamer by receive email input and let the user
     * edit point.
     */
    public void updateGamer() {
	Scanner sc = new Scanner(System.in);
	Gamer data = inputMailForSearchGamer();
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    int point = 0;
	    System.out.println("Email: " + data.getEmail());
	    System.out.print("Point: ");
	    try {
		point = Integer.parseInt(sc.nextLine());
		if (point < 0) {
		    System.out.println("point must be positive!!");
		}
	    } catch (Exception e) {
		System.out.println("Wrong format");
	    }
	    data.setPoint(point);
	}
    }

    /**
     * this method use to input Mail and return Gamer.
     *
     * @return Gamer
     */
    public Gamer inputMailForSearchGamer() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter email: ");
	String email = sc.nextLine();
	Gamer data = list.searchGamerByEmail(email);
	return data;
    }
    
    public void printQueue() {
	list.printList(list);
    }
}
