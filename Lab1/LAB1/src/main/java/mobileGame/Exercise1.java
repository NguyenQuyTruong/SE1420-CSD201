/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.IOException;
import java.util.Scanner;

/**
 *
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
//    public void getArgument(String[] args) {
//	try {
//	    switch(args[0]) {
//		case "-r": //read CSV file and add to queue
//		    queue = new PriorityQueue();
//		    FileDAO.ReadFile(queue, args[1]);
//		    break;
//		case "-s": //import the queue to new CSV file
//		    saveToFile(args[1]);
//		    break;
//		case "-a": //insert new Gamer to queue
//		    insertNewGamer(args[1], args[2]);
//		    break;
//		case "-d": //delete gamer from queue
//		    deleteGame(args[1]);
//		    break;
//		case "-u": //update gamer
//		    updateGamer(args[1], args[2]);
//		    break;
//		case "-dt": //delete top gamer
//		    deleteTopGamer();
//		    break;
//		case "-g": //get point of gamer
//		    searchGamer(args[1]);
//		    break;
//		case "-t": //get point of top gamer
//		    getTopGamer();
//		    break;
//		default:
//		    System.out.println("Error: command not found!!");
//	    }
//	} catch (ArrayIndexOutOfBoundsException e) {
//	    System.out.println("Can't find argument to excecute!");
//	}
//    }

    public static void main(String[] args) {
	Exercise1 ex = new Exercise1();
//	final String[] ID = Arrays.copyOfRange(args, 1, args.length);
//	String choice;
//
//	try {
//	    switch(args[0]) {
//		case "-r": //read CSV file and add to queue
//		    queue = new PriorityQueue();
//		    queue.ReadFile(queue, args[1]);
//		    break;
//		case "-s": //import the queue to new CSV file
//		    ex.saveToFile(args[1]);
//		    break;
//		case "-a": //insert new Gamer to queue
//		    ex.insertNewGamer(args[1], args[2]);
//		    break;
//		case "-d": //delete gamer from queue
//		    ex.deleteGame(args[1]);
//		    break;
//		case "-u": //update gamer
//		    ex.updateGamer(args[1], args[2]);
//		    break;
//		case "-dt": //delete top gamer
//		    ex.deleteTopGamer();
//		    break;
//		case "-g": //get point of gamer
//		    ex.searchGamer(args[1]);
//		    break;
//		case "-t": //get point of top gamer
//		    ex.getTopGamer();
//		    break;
//		default:
//		    System.out.println("Error: command not found!!");
//	    }
//	} catch (ArrayIndexOutOfBoundsException e) {
//	    System.out.println("Can't find argument to excecute!");
//	}
//	if (args.length > 0) {
//	    System.out.println("The command line"
//		    + " arguments are:");
//
//	    // iterating the args array and printing
//	    // the command line arguments
//	    for (String val : args) {
//		System.out.println(val);
//	    }
//	} else {
//	    System.out.println("No command line "
//		    + "arguments found.");
//	}
	System.out.println("");
	//	Scanner sc = new Scanner(System.in);
//	int choice = 0;
//	do {
//	    System.out.println("1. Read file");
//	    System.out.println("2. Save file");
//	    System.out.println("3. add Gamer");
//	    System.out.println("4. delete Gamer");
//	    System.out.println("5. update Gamer");
//	    System.out.println("6. delete top");
//	    System.out.println("7. search Gamer");
//	    System.out.println("8. get top");
//	    System.out.println("9. Exit");
//	    System.out.print("Choice: ");
//	    choice = sc.nextInt();
//	    switch (choice) {
//		case 1: //read CSV file and add to queue
//		    queue = new PriorityQueue();
//		    queue.ReadFile(queue, "user.csv");
//		    break;
//		case 2: //import the queue to new CSV file
//		    ex.saveToFile("newUser.csv");
//		    break;
//		case 3: //insert new Gamer to queue
//		    System.out.print("Email: ");
//		    String email = sc.nextLine();
//		    System.out.print("point: ");
//		    String point = sc.nextLine();
//		    ex.insertNewGamer(email, point);
//		    break;
//		case 4: //delete gamer from queue
//		    System.out.print("Email: ");
//		    String email1 = sc.nextLine();
//		    ex.deleteGame(email1);
//		    break;
//		case 5: //update gamer
//		    System.out.print("Email: ");
//		    String email2 = sc.nextLine();
//		    System.out.print("point: ");
//		    String point2 = sc.nextLine();
//		    ex.updateGamer(email2, point2);
//		    break;
//		case 6: //delete top gamer
//		    ex.deleteTopGamer();
//		    break;
//		case 7: //get point of gamer
//		    System.out.print("Email: ");
//		    String email3 = sc.nextLine();
//		    ex.searchGamer(email3);
//		    break;
//		case 8: //get point of top gamer
//		    ex.getTopGamer();
//		    break;
//		default:
//		    System.out.println("Error: command not found!!");
//	    }
//	} while (choice != 9);
    }
}
