/**
 * 
 */
package headPack;

import java.util.Arrays;

import problem1.Problem1;
import problem2.Problem2;

/**
 * @author vo ngoc khang
 *
 */
public class Main {
	
	static String tutorials = "./lab1 -h\r\n" + 
			"   Help me please: \r\n" + 
			"   ./lab1 1 -r <<user_CSV_file>>: Problem 1, read the user csv file\r\n" + 
			"   ./lab1 1 -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre\r\n" + 
			"   ./lab1 1 -d <<email>>: Problem 1, delete a user in the data strucutre\r\n" + 
			"   ./lab1 1 -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre\r\n" + 
			"   ./lab1 1 -g <<email>>: Problem 1, get the point of user from the data strucutre\r\n" + 
			"   ./lab1 1 -t: Problem 1, get the point of the top user from the data strucutre\r\n" + 
			"   ./lab1 1 -dt: Problem 1, delete the top user from the data strucutre\r\n" + 
			"   ./lab1 1 -s <<new_user_CSV_file>>: Problem 1, save the data strucutre into csv file\r\n" + 
			"   ./lab1 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";


	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();
		Problem2 problem2 = new Problem2();
		if (args.length > 0) {
			final String[] parametersRemovedProblemID = Arrays.copyOfRange(args, 1, args.length); 
			//remove the problemID from parameter, leave the rest
			
			switch (args[0]) {
			case "1":
				problem1.ParseArguments(parametersRemovedProblemID);
				break;
			case "2":
				problem2.ParseArguments(parametersRemovedProblemID);
				break;
			default:
				System.out.println("Not valid arguments, please see tutorial\n" + tutorials);
				
			}	
		}
		
		
	}

}
