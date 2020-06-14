/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	list.addBetween(data);
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
     *
     * @param email
     * @return Gamer
     */
    public Gamer deleteGamer(String email) {
	Gamer data = list.removeNode(email);
	return data;
    }

    /**
     * this method will receive email input and return Gamer, if the list don't
     * have this gamer return null
     *
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
     *
     * @param email
     * @param point
     */
    public void updateGamer(String email, int point) {
	Gamer data = list.searchGamerByEmail(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    data.setPoint(point);
	    list.removeNode(email);
	    list.addBetween(data);
	    System.out.println("Update point successfull");
	    System.out.println("Email: " + email + ", New point: " + data.getPoint());
	}
    }

    /**
     * this method use to Read the file and import Gamer data(email, point) to
     * the queue
     *
     * @param queue
     * @param fileName
     */
    public void ReadFile(PriorityQueue queue, String fileName) {
	FileReader fr = null;
	BufferedReader bf = null;
	try {
	    fr = new FileReader(fileName);
	    bf = new BufferedReader(fr);
	    while (bf.ready()) {
		String s = bf.readLine();
		String[] arr = s.split(", ");
		if (!(arr[1].equalsIgnoreCase("point"))) {
		    queue.push(new Gamer(arr[0], Integer.valueOf(arr[1])));
		}
	    }
	} catch (IOException e) {
	    System.out.println("File not exist!!");
	} finally {
	    try {
		if (fr != null) {
		    fr.close();
		}
		if (bf != null) {
		    bf.close();
		}
	    } catch (IOException e) {
		System.out.println("Something wrong with Reading file");
	    }
	}
    }

    //write file method
    public void writeFile(String fileName) throws IOException {
	list.writeToCSVfile(fileName);
    }

    //this method use to testing =))
    public void printQueue() {
	list.printList();
    }
}