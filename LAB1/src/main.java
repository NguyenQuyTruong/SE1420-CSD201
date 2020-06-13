/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class main {

    public static queue queue;

    public void NewGamer(String email, String point) {
        try {
            int checkPoint = Integer.parseInt(point.trim());
            queue.insert(new manageGamer(email, checkPoint));
        } catch (NumberFormatException e) {
            System.out.println("must be integer!!");
        }
    }
public void searchGamer(String email) {
	manageGamer data = queue.searchUser(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("email: " + email + ", point: " + data.getPoint());
	}
    }
public void deleteGame(String email) {
	manageGamer data = queue.deleteUser(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("remove " + email + " successful!");
	}
    }
 public void updateGamer(String email, String point) {
	try {
	    int newPoint = Integer.parseInt(point.trim());
	    queue.updateUser(email, newPoint);
	} catch (NumberFormatException e) {
	    System.out.println("must be Integer!!");
	}
    }
 public void getTopGamer() {
	manageGamer data = queue.getTop();
	System.out.println("A best gamer here:");
	System.out.println("Email: " + data.getUserEmail() + ", Point: " + data.getPoint());
    }
 public void deleteTopGamer() {
	queue.deleteTop();
	System.out.println("remove successful!!");
    }
    public static void main(String[] args) {
        String input = "";
        String output = "";
        try {
           
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Can't find!");
        }
        System.out.println("Input: " + input);
        System.out.println("output: " + output);
    }
}
