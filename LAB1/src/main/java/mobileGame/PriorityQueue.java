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
//	System.out.println("push Gamer data successful!!");
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

    /**
     * this method will delete Gamer depend on input email
     */
    public void deleteGamer() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter email: ");
	String email = sc.nextLine();
	Gamer data = list.removeNode(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Remove " + data.getEmail() + " successful!");
	}
    }

    /**
     * this method will receive email input and return Gamer, if the list don't
     * have this gamer return null
     * @param email
     * @return Gamer
     */
    public Gamer searchGamer(String email) {
	Gamer data = list.searchGamerByEmail(email);
	return data;
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

    //write file method
    public void writeFile(String fileName) {
	list.writeToCSVfile(fileName);
    }

    //this method use to testing =))
    public void printQueue() {
	list.printList();
    }
}
