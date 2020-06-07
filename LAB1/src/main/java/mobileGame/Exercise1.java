/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhoxr
 */
public class Exercise1 {

    PriorityQueue queue;

    /**
     * this method use to add new Gamer to queue
     *
     * @param email
     * @param point
     */
    public void insertNewGamer(String email, String point) {
	try {
	    int checkPoint = Integer.parseInt(point.trim());
	    queue.push(new Gamer(email, checkPoint));
	} catch (NumberFormatException e) {
	    System.out.println("Point must be integer!!");
	}
    }

    /**
     * this method use to Find point of Gamer depend on email input
     *
     * @param email
     */
    public void searchGamer(String email) {
	Gamer data = queue.searchGamer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Email: " + email + ", Point: " + data.getPoint());
	}
    }

    /**
     * this method use to Delete Gamer depend on email input
     *
     * @param email
     */
    public void deleteGame(String email) {
	Gamer data = queue.deleteGamer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Remove " + email + " successful!");
	}
    }

    /**
     * this method use to update point of Gamer depend on email input
     * @param email
     * @param point
     */
    public void updateGamer(String email, String point) {
	try {
	    int newPoint = Integer.parseInt(point.trim());
	    queue.updateGamer(email, newPoint);
	} catch (NumberFormatException e) {
	    System.out.println("Point must be Integer!!");
	}
    }

    /**
     * this method use to get top 1 Gamer
     */
    public void getTopGamer() {
	Gamer data = queue.getTop();
	System.out.println("Top 1 Gamer:");
	System.out.println("Email: " + data.getEmail() + ", Point: " + data.getPoint());
    }

    /**
     * this method use to delete top 1 Gamer
     */
    public void deleteTopGamer() {
	queue.deleteTop();
	System.out.println("Remove top successful!!");
    }

    /**
     * this method use to write all the queue to the file
     * @param fileName
     */
    public void saveToFile(String fileName) {
	try {
	    FileDAO.writeFile(queue, fileName);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public void getArgument(String[] args) {
	try {
	    switch(args[0]) {
		case "-r": //read CSV file and add to queue
		    queue = new PriorityQueue();
		    FileDAO.ReadFile(queue, args[1]);
		    break;
		case "-s": //import the queue to new CSV file
		    saveToFile(args[1]);
		    break;
		case "-a": //insert new Gamer to queue
		    insertNewGamer(args[1], args[2]);
		    break;
		case "-d": //delete gamer from queue
		    deleteGame(args[1]);
		    break;
		case "-u": //update gamer
		    updateGamer(args[1], args[2]);
		    break;
		case "-dt": //delete top gamer
		    deleteTopGamer();
		    break;
		case "-g": //get point of gamer
		    searchGamer(args[1]);
		    break;
		case "-t": //get point of top gamer
		    getTopGamer();
		    break;
		default:
		    System.out.println("Error: command not found!!");
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Can't find argument to excecute!");
	}
    }
}
