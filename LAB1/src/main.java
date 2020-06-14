
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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

    public static void NewGamer(String email, String point) {
        try {
            int checkPoint = Integer.parseInt(point.trim());
            queue.insert(new manageGamer(email, checkPoint));
        } catch (NumberFormatException e) {
            System.out.println("must be integer!!");
        }
    }

    public static void searchGamer(String email) {
        manageGamer data = queue.searchUser(email);
        if (data == null) {
            System.out.println("not found!!");
        } else {
            System.out.println("email: " + email + ", point: " + data.getPoint());
        }
    }

    public static void deleteGame(String email) {
        manageGamer data = queue.deleteUser(email);
        if (data == null) {
            System.out.println("Not found!!");
        } else {
            System.out.println("remove " + email + " successful!");
        }
    }

    public static void updateGamer(String email, String point) {
        try {
            int newPoint = Integer.parseInt(point.trim());
            queue.updateUser(email, newPoint);
        } catch (NumberFormatException e) {
            System.out.println("must be Integer!!");
        }
    }

    public static void getTopGamer() {
        manageGamer data = queue.getTop();
        System.out.println("A best gamer here:");
        System.out.println("email: " + data.getUserEmail() + ", point: " + data.getPoint());
    }

    public static void deleteTopGamer() {
        queue.deleteTop();
        System.out.println("remove successful!!");
    }
     private static int contains(String[] arr, String value) {
	int result = -1;

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i].equals(value)) {
		result = i;
	    }
	}
	return result;
    }
    private static String CLIcheck(String[] args) {
	String result = "";
	if (args.length != 0 && !args[0].equals("-h")) {
	    if (!args[0].equals("1") && !args[0].equals("2")) {
		result = result + "Error: The problem name is not correct !";
	    } else if (args[0].equals("1") && contains(args, "-r") == -1) {
		result = result + "Error: No user input file !";
	    } else if (args[0].equals("1") && contains(args, "-r") != -1 && contains(args, "-r") + 1 >= args.length) {
		result = result + "Error: No input filename !";
	    } else if (args[0].equals("2") && args.length < 3) {
		result = result + "Error: Your CLI format is not correct !";
	    }
	} else {
	    result += "Help:\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result += "./lab1 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file\n";
	}

	return result;
    }
    public static void main(String[] args) {
        
    }
}
