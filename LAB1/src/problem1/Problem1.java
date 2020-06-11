package problem1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Problem1{	
	
	/**
	 * 
	 */
	private static final String storageFile = "problem1.data";
	
	PriorityQueue queue;
	public Problem1() {
		queue = new PriorityQueue();
		
	}
	

	private void InsertNewData(String email, String point){
		try {
			long lpoint = Long.parseLong(point.trim()); //parse string to long
			queue.insert(email, lpoint);
			
				
		}catch(NumberFormatException e) {
			System.out.println("ERROR: Please make sure the point is number!");
		}
		
	}
	
	/**
	 * Delete user by email
	 * @param email
	 */
	private void DeleteEmail(String email) {
		queue.Delete(email);
	}
	
	
	/**
	 * Get point of user
	 * @param email
	 */
	private void GetPointUser(String email) {
		Long point = queue.GetPoint(email);
		if (point == null) {
			System.out.println("CAN'T find " + email + " please try again!");
		}else {
			System.out.println(email + " : " + point + " points");
		}
	}

	
	/**
	 * update new user
	 * @param email
	 * @param point
	 */
	private void UpdateUser(String email, String point) {
		try {
			long newPoint = Long.parseLong(point.trim()); //parse string to long
			queue.Update(email, newPoint);	
			
		}catch(NumberFormatException e) {
			System.out.println("ERROR: Please make sure the point is number!");
		}
		
	}

	/**
	 * Get user most point
	 */
	private void GetTopPointUser() {
		queue.getTop();
	}

	/**
	 * Delete most point user
	 */
	private void DeleteTopUser() {
		queue.DeleteTop();
	}
	
	/**
	 * Save data to csv file
	 */
	private void SaveCSV(String path) {
		try {
			CSV.WriteQueueIntoCSV(queue, path);
		} catch (IOException e) {
			System.out.println("Error: something wrong then write file to CSV!");
		}
		
	}
	
	
	/**
	 * parse the rest of arguments then excecute command
	 * @param args
	 */
	public void ParseArguments(String[] args) {
		/*
		try {
			switch(args[0]) {
			case "-r": //read csv
				queue = new PriorityQueue(); //make new one! (clear old data)
				CSV.ReadAndPushToQueue(queue, args[1]);
				break;
			case "-a": //add new user
				InsertNewData(args[1], args[2]);
				break;
			case "-d": //delete a user
				DeleteEmail(args[1]);
				break;
			case "-u":
				UpdateUser(args[1], args[2]);
				break;
			case "-g":
				GetPointUser(args[1]);
				break;
			case "-t":
				GetTopPointUser();
				break;
			case "-dt":
				DeleteTopUser();
				break;
			case "-s":
				SaveCSV(args[1]);
				break;
			default:
				System.out.println("Command not found, try again!");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough argument to excecute command!");
		}catch (IOException e) {
			System.out.println("There is an error happen, please check your csv file or any input parameter");
		}
		
		SaveData();
		*/
		
	}





	
}
