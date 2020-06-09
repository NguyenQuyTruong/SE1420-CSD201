package Ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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

    public static void main(String[] args) throws IOException {
        MyQueue mq = new MyQueue();
        int i = 0;
        String oldFileName = null;
        String newFileName = null;
        String email;
        String point;
        int choice = 0;
        if (args[0].equals("-h")) {
            System.out.println("Exercise 1");
            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n");
            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n");
            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n");
            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n");
            System.out.print("java -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n");
            System.out.print("java -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n");
            System.out.print("java -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
        }

        while (args[i] != null) {
            if (args[i].equals("-r")) {
                oldFileName = args[i + 1];
            }
            if (args[i].equals("-s")) {
                newFileName = args[i + 1];
            }
            if (args[i].equals("-a")) {
                email = args[i + 1];
                point = args[i + 2];
                choice = 2;
            }
            if (args[i].equals("-d")) {
                email = args[i + 1];
                choice = 3;
            }
            if (args[i].equals("-u")) {
                email = args[i + 1];
                point = args[i + 2];
                choice = 4;
            }
            if (args[i].equals("-dt")) {
                choice = 5;
            }
            if (args[i].equals("-g")) {
                email = args[i + 1];
                choice = 6;
            }
            if (args[i].equals("-t")) {
                choice = 7;
            }
            i++;
        }
        switch (choice) {
            case 0: {
                BufferedReader bufferedReader = null;
                BufferedWriter bufferedWriter = null;

                try {
                    Reader reader = new FileReader(oldFileName);
                    Writer writer = new FileWriter(newFileName);

                    bufferedReader = new BufferedReader(reader);
                    bufferedWriter = new BufferedWriter(writer);

                    int c;
                    while ((c = bufferedReader.read()) != -1) {
                        bufferedWriter.write(c);
                    }
                } finally {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                }
                break;
            }
            case 1: {
                
                break;
            }

        }
    }
}
}
