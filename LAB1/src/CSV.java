

import java.util.Arrays;
import javax.xml.soap.Node;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class CSV {
    public static String tutorials = "java -jar LAB1.jar -h\r\n"
            + "Help: \r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\r\n"
            + "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file.";
    
    public static void main(String[] args) {
        CSV csv = new CSV();
        if(args.length > 0){
            final String[] RemovedProblemID  = Arrays.copyOfRange(args, 1, args.length);
            switch(args[0]){
                case "1":
                    csv.ParseArgument(RemovedProblemID);
                    break;
                case "2":
                    System.out.println(tutorials);
                    break;
                default:
                    System.out.println("Not exsit, please choose again!");
                    break;
            }
        }
    }

    private void ParseArgument(String[] parametersRemovedProblemID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
