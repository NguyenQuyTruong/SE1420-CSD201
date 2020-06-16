package com.company;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserList list = new UserList();
        switch(args[0]){
            case "-h":
                System.out.println("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
"java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
                break;
            case "1":
                list.Read(args[2]);
                switch (args[3]){
                    case "-s":
                        try{
                        switch (args[5]){
                            case "-a":
                                list.Insert(args[6], Integer.parseInt(args[7]));
                                break;
                            case "-d":
                                list.Remove(args[6]);
                                break;
                            case "-u":
                                list.Update(args[6], Integer.parseInt(args[7]));
                                break;
                            case "-dt":
                                list.removeTop();
                                break;
                        }} catch(Exception e){}
                        list.printFile(args[4]);
                        break;
                    case "-g":
                        System.out.println("Point: "+list.pPoint(list.getUser(args[4])));
                        break;
                    case "-t":
                        System.out.println("User: "+list.pEmail(list.getTop())+" - Point: "+list.pPoint(list.getTop()));
                        break;
                }
                break;
            case "2":
                break;
        }
    }
    
}
