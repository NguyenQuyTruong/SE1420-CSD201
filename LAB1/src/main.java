
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
/**
 * add new gamer to queue
 * @param email
 * @param point 
 */
    public static void NewGamer(String email, String point) {
        try {       // add a new gamer to queue
            int checkPoint = Integer.parseInt(point.trim());    
            queue.insert(new manageGamer(email, checkPoint));
        } catch (NumberFormatException e) {
            System.out.println("must be integer!!");
        }
    }
/**
 * search user by email
 * @param email 
 */
    
    public static void searchGamer(String email) {
        manageGamer data = queue.searchUser(email);     //that method for search someone by email
        if (data == null) {                             // if it no one, we have not found
            System.out.println("not found!!");
        } else {
            System.out.println("email: " + email + ", point: " + data.getPoint());
        }
    }
/**
 * delete user by email (node)
 * @param email 
 */
    public static void deleteGame(String email) {
        manageGamer data = queue.deleteUser(email);     //that method for delete user by email
        if (data == null) {                             // if it no one, we have not found
            System.out.println("Not found!!");
        } else {
            System.out.println("remove " + email + " successful!");
        }
    }
/**
 * update email and point, parse point from string (arg) to int
 * @param email
 * @param point 
 */
    public static void updateGamer(String email, String point) {
        try {
            int newPoint = Integer.parseInt(point.trim());  //arg always a string, so we need pasrse int
            queue.updateUser(email, newPoint);              //upadte
        } catch (NumberFormatException e) {
            System.out.println("must be Integer!!");
        }
    }
/**
 * get user by highest point 
 */
    public static void getTopGamer() {
        manageGamer data = queue.getTop();                  //get a gamer from fisrt place
        System.out.println("A best gamer here:");
        System.out.println("email: " + data.getUserEmail() + ", point: " + data.getPoint());
    }
/**
 * delete a user in a first place
 */
    public static void deleteTopGamer() {
        queue.deleteTop();                                  //dele a gamer in first place
        System.out.println("remove successful!!");
    }
/**
 * main EX1
 * @param args 
 */

    public static void main(String[] args) {
        queue q = new queue();                              //add queue
        String email = null;
        int point = 0;
        String oldfile = null;
        String newfile = null;
        int choice = 0;
        if (args[0].equals("-h")) {
            System.out.println("Exercise 1");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucuture into csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
            System.out.print("java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
            return;
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-r")) {
                oldfile = args[i + 1];

            }
            if (args[i].equals("-s")) {
                newfile = args[i + 1];
            }
            if (args[i].equals("-a")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 1;
            }
            if (args[i].equals("-d")) {
                email = args[i + 1];
                choice = 2;
            }
            if (args[i].equals("-u")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 3;
            }
            if (args[i].equals("-dt")) {
                choice = 4;
            }
            if (args[i].equals("-g")) {
                email = args[i + 1];
                choice = 5;
            }
            if (args[i].equals("-t")) {
                choice = 6;
            }

            switch (choice) {
                case 0: {
                    queue = new queue();
                    oldfile = args[i + 1];
                    queue.ReadFile(queue, oldfile);
                    break;
                }
                case 1: {
                    NewGamer(args[i + 1], args[i + 2]);
                    break;
                }
                case 2: {
                    deleteGame(email);
                    break;
                }
                case 3: {
                    updateGamer(args[i + 1], args[i + 2]);
                    break;
                }
                case 4: {
                    deleteTopGamer();
                    break;
                }
                case 5: {
                    searchGamer(email);
                    break;
                }
                case 6: {
                    getTopGamer();
                    break;
                }

            }
        }

    }
}
