/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khả Thi
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
           PriorityQueue queue;
           String filename;
    public Lab() {
	}
	
        /**
	 * Insert new user to the queue
	 * @param email,point
	 */
	private void InsertNew(String email, String point){
		try {
			long lpoint = Long.parseLong(point.trim()); //parse string to long
			queue.InSert(email, lpoint);
			
				
		}catch(NumberFormatException e) {
			System.out.println("ERROR: Please make sure the point is number!");
		}
		
	}
	
	/**
	 * Delete user by email
	 * @param Demail
	 */
	private void DeleteEmail(String Demail) {
		queue.Delete(Demail);
	}
	
	
	/**
	 * Get point by email
	 * @param GPoint
	 */
	private void GetPoint(String GPoint) {
		Long point = queue.GetP(GPoint);
		if (point == null) {
			System.out.println("Some thing wrong!");
		}else {
			System.out.println(point);
		}
	}

	
	/**
	 * update new point by email
	 * @param Uemail
	 * @param Upoint
	 */
	private void UpdateUser(String Uemail, String Upoint) {
		try {
			long newPoint = Long.parseLong(Upoint.trim());
			queue.Update(Uemail, newPoint);	
			
		}catch(NumberFormatException e) {
			System.out.println("Some thing wrong!");
		}
		
	}

	/**
	 * Get top user
	 */
	private void GetTopPointUser() {
		queue.Gettop();
	}

	/**
	 * Delete top user
	 */
	private void DeleteTopUser() {
		queue.DeleteT();
	}
	
	/**
	 * Save data 
	 */
	private void SaveCSV(String path) {
		try {
			Csv.WriteToFile(queue, path);
		} catch (IOException e) {
			System.out.println("Some Thing wrong!");
		}
		
	}
          /**
	 * Finnal step run program
	 * @param args
        * @throws java.io.IOException
	 */
    public void main(String[] args) throws IOException  {
        // TODO code application logic here
        boolean saveB = false;
        String Path = null;
        try {
			for(int i = 0; i < args.length; i++) {
				switch(args[i]) {
				case "-r":
					queue = new PriorityQueue();
					Csv.ReadCsv(args[i+1],queue);
					break;
					
				case "-a":
					InsertNew(args[i+1], args[i+2]);
					break;
					
				case "-d":
					DeleteEmail(args[i+1]);
					break;
					
				case "-u":
					UpdateUser(args[i+1], args[i+2]);
					break;
				
				case "-dt":
					DeleteTopUser();
					break;
				
				case "-g":
					GetPoint(args[i+1]);
					break;
				
				case "-t":
					GetTopPointUser();
					break;
					
					
				case "-s":
					saveB = true; 
					Path = args[i+1];
					break;
				default:
					break;
				}
				
			}
			
			//after every command, save is the last
			if (saveB) {
				SaveCSV(Path);
			}
			
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough arguments to execute commands");
		}catch (IOException e) {
			System.out.println("Error while reading csv file");
		}
        
    }
    
}
