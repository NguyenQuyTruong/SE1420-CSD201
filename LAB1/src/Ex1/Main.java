package Ex1;

import java.io.BufferedWriter;
import java.io.File;
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
 * @author KHAM
 */
public class Main {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        int i = 0;
        String oldFileName = null;
        String newFileName = null;
        String email;
        int point;
        int choice = 0;
//        if (args[0].equals("-h")) {
//            System.out.println("Exercise 1");
//            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucuture into csv file\n");
//            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n");
//            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n");
//            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n");
//            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n");
//            System.out.print("java -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n");
//            System.out.print("java -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
//        }

//        for (i = 0; i < args.length; i++) {
//
//            if (args[i].equals("-r")) {
//                oldFileName = args[i + 1];
//            }
//            if (args[i].equals("-s")) {
//                newFileName = args[i + 1];
//            }
//            if (args[i].equals("-a")) {
//                email = args[i + 1];
//                point = Integer.parseInt(args[i + 2]);
//                choice = 1;
//            }
//            if (args[i].equals("-d")) {
//                email = args[i + 1];
//                choice = 2;
//            }
//            if (args[i].equals("-u")) {
//                email = args[i + 1];
//                point = Integer.parseInt(args[i + 2]);
//                choice = 3;
//            }
//            if (args[i].equals("-dt")) {
//                choice = 4;
//            }
//            if (args[i].equals("-g")) {
//                email = args[i + 1];
//                choice = 5;
//            }
//            if (args[i].equals("-t")) {
//                choice = 6;
//            }
//        }
        switch (choice) {
            case 0: {
                try {
                    FileReader file = new FileReader("user.csv");
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter("newuser.csv");
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNextLine()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
//                            Entry e = new Entry(pointRead, emailRead);
//                            mq.enqueue(e);

                        }
                        inputStream.close();
                    }
//                    pw.println("Email ,Point\n");
//                    pw.write(mq.print());
//                    pw.close();
                } catch (IOException e) {
                    System.out.println("File not found");
                }
                break;
            }
            case 1: {
                break;
            }

        }
    }
}
