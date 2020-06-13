/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author minhv
 */
public class Main {

    public static void CLI(String[] args) {
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
	} else if (args[0].equals("1") && contains(args, "-r") == -1) {
	    result = result + "Error: No user input file !";
	} else if (args[0].equals("1") && contains(args, "-r") != -1 && contains(args, "-r") + 1 >= args.length) {
	    result = result + "Error: No input filename !";
	} else if (args[0].equals("2") && args.length < 3) {
	    result = result + "Error: Your CLI format is not correct !";
	}
	return result;
    }
    
    pbulic static void 

    public static void main(String[] args) {

    }
}
