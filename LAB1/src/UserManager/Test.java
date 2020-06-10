/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

import HTMLParser.HTMLValidateAndCount;
import HTMLParser.Stack;
import java.util.Scanner;

/**
 *
 * @author minhv
 */
public class Test {

    public static void main(String[] args) {
	PriorityQueue list = new PriorityQueue();
	Scanner sc = new Scanner(System.in);
	int choice;
	do {
	    System.out.print("Choice: ");
	    sc = new Scanner(System.in);
	    choice = Integer.parseInt(sc.nextLine());
	    switch (choice) {
		case 1:
		    FileWriteRead.readData("user.csv", list);
		    break;
		case 2:
		    System.out.print("Email: ");
		    sc = new Scanner(System.in);
		    String email = sc.nextLine();
		    list.deleteUser(email);
		    break;
		case 3:
		    System.out.print("Email: ");
		    sc = new Scanner(System.in);
		    email = sc.nextLine();
		    sc = new Scanner(System.in);
		    System.out.print("Point: ");
		    int point = Integer.parseInt(sc.nextLine());
		    list.updateUser(email, point);
		    FileWriteRead.writeData("user.csv", list);
		    break;
		case 4:
		    System.out.print("Email: ");
		    sc = new Scanner(System.in);
		    email = sc.nextLine();
		    list.searchUser(email);
		    break;
		case 5:
		    list.removeTop();
		    break;
		case 6:
		    list.getTop();
		    break;
		case 7:
		    System.out.print("Email: ");
		    sc = new Scanner(System.in);
		    email = sc.nextLine();
		    list.displayPointUserEmail(email);
		    break;
		case 8: 
		    list.printlist(list);
		    break;
	    }
	} while (choice != 9);
//	HTMLValidateAndCount html = new HTMLValidateAndCount();
//	String tag = sc.nextLine();
//	System.out.println(html.checkTag(tag));
	

//	User user1 = new User("123", 1);
//	User user2 = new User("436", 2);
//	User user3 = new User("234", 3);
//	User user4 = new User("356", 4);
//	User user5 = new User("174", 5);
//	User user6 = new User("252", 6);
//	User user10 = new User("261", 10);
//	list.add(user1);
//	list.add(user5);
//	list.add(user3);
//	list.add(user6);
//	list.add(user2);
//	list.add(user4);
//	list.add(user10);
//	list.printlist(list);
    }
}
