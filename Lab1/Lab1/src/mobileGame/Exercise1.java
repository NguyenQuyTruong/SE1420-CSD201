/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.IOException;

/**
 * @author nhoxr
 */
public class Exercise1 {

    public static PriorityQueue queue;

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
     *
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
     * this method use to get top 1 Gamer and print info to screen
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
     *
     * @param fileName
     * @throws java.io.IOException
     */
    public void saveToFile(String fileName) throws IOException {
	queue.writeFile(fileName);
    }

    public void printQueue() {
	queue.printQueue();
    }

    public void inputCLI(String[] args) throws IOException {
	Exercise1 ex = new Exercise1();
	String inputFile = "";
	String outputFile = "";
	try {
	    for (int i = 0; i < args.length; i++) {
		switch (args[i]) {
		    case "-r": //read CSV file and add to queue
			queue = new PriorityQueue();
			inputFile = args[i + 1];
			queue.ReadFile(queue, inputFile);
			break;
		    case "-s": //import the queue to new CSV file
			outputFile = args[i + 1];
			ex.saveToFile(outputFile);
			break;
		    case "-a": //insert new Gamer to queue
			ex.insertNewGamer(args[i + 1], args[i + 2]);
			ex.saveToFile(outputFile);
			break;
		    case "-d": //delete gamer from queue
			ex.deleteGame(args[i + 1]);
			ex.saveToFile(outputFile);
			break;
		    case "-u": //update gamer
			ex.updateGamer(args[i + 1], args[i + 2]);
			ex.saveToFile(outputFile);
			break;
		    case "-dt": //delete top gamer
			ex.deleteTopGamer();
			ex.saveToFile(outputFile);
			break;
		    case "-g": //get point of gamer
			ex.searchGamer(args[i + 1]);
			break;
		    case "-t": //get point of top gamer
			ex.getTopGamer();
			break;
		}
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Can't find argument to excecute!");
	}
    }
}
