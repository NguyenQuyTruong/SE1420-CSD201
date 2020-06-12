/*
 * 
 * 
 * 
 */
package exercise1;

import java.util.Arrays;

/**
 *
 * @author 
 */
public class Main {

    static String tutorials = "java -jar LAB1.jar -h\r\n"
            + "Help: \r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\r\n"
            + "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";

    public static void main(String[] args) {
        Excersise1 e = new Excersise1();
        if (args.length > 0) {
            final String[] parametersRemovedProblemID = Arrays.copyOfRange(args, 1, args.length);
            switch (args[0]) {
                case "1":
                    e.ParseArgument(parametersRemovedProblemID);
                    break;
                case "2":
                    break;
                case "-h":
                    System.out.println(tutorials);
                    break;
                default:
                    System.out.println("choose wrong, choose again, please see tutorials\n" + tutorials);
                    break;
            }
        }
    }
}
