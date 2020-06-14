/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import HTMLParser.HTMLValidateAndCount;
import UserManager.FileProcessUser;
import UserManager.PriorityQueue;
import UserManager.User;
import java.io.IOException;

/**
 *
 * @author minhv
 */
public class Main {

    /**
     * Display help and prevent some error from inputted
     * @param args
     * @return 
     */
    public static String CLI(String[] args) {
	String result = "";
	if (args.length == 0 || args[0].equals("-h")) {
	    result = result + "Help:\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result = result + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result = result + "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file\n";
	} else if (!args[0].equals("1") && !args[0].equals("2")) {
	    result = result + "Error: The problem name is not correct !";
	} else if (args[0].equals("1") && include(args, "-r") == -1) {
	    result = result + "Error: No user input file !";
	} else if (args[0].equals("1") && include(args, "-r") != -1 && include(args, "-r") + 1 >= args.length) {
	    result = result + "Error: No input filename !";
	} else if (args[0].equals("1") && include(args, "-s") != -1) {
	    result = result + "Error: No user output file !";
	} else if (args[0].equals("1") && include(args, "-s") != -1 && include(args, "-s") + 1 >= args.length) {
	    result = result + "Error: No output filename !";
	} else if (args[0].equals("2") && args.length < 3) {
	    result = result + "Error: Your CLI format is not correct !";
	}
	return result;
    }

    /**
     * Get input from String args
     * @param array
     * @param value
     * @return String
     */
    public static int include(String[] array, String value) {
	int result = -1;
	for (int i = 0; i < array.length; i++) {
	    if (array[i].equals(value)) {
		result = i;
		break;
	    }
	}
	return result;
    }

    /**
     * Main class
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
	String result = CLI(args);
	if (result.equals("") && args[0].equals("1")) {
	    PriorityQueue queue = new PriorityQueue();
	    FileProcessUser.readData(args[include(args, "-r") + 1], queue);
	    if (include(args, "-t") != -1) {
		queue.getTop();
	    } else if (include(args, "-g") != -1) {
		queue.searchUser(args[include(args, "-g") + 1]);
	    } else if (include(args, "-dt") != -1) {
		queue.removeTop();
		FileProcessUser.writeData(args[include(args, "-s") + 1].trim(), queue);
	    } else if (include(args, "-u") != -1) {
		int point = Integer.parseInt(args[include(args, "-u") + 2]);
		String email = args[include(args, "-u") + 1].trim();
		queue.updateUser(email, point);
		FileProcessUser.writeData(args[include(args, "-s") + 1].trim(), queue);
	    } else if (include(args, "-d") != -1) {
		queue.deleteUser(args[include(args, "-d") + 1]);
		FileProcessUser.writeData(args[include(args, "-s") + 1].trim(), queue);
	    } else if (include(args, "-a") != -1) {
		int point = Integer.parseInt(args[include(args, "-a") + 2]);
		String email = args[include(args, "-a") + 1].trim();
		queue.insertUser(new User(email, point));
		FileProcessUser.writeData(args[include(args, "-s") + 1].trim(), queue);
	    } else {
		FileProcessUser.writeData(args[include(args, "-s") + 1].trim(), queue);
	    }
	} else if (result.equals("") && args[0].equals("2")) {
	    HTMLValidateAndCount html = new HTMLValidateAndCount();
	    html.manage(args[2], args[1]);
	} else {
	    System.out.println(result);
	}
    }
}
