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
		
		LoadData(); //load previous data
	}
	
	public void LoadData() {
		try {
			FileInputStream inputStream = new FileInputStream(storageFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			queue = (PriorityQueue) objectInputStream.readObject();
			
			inputStream.close();
			objectInputStream.close();
			
			System.out.println("Loaded previous data!");
		} catch (FileNotFoundException e) {
			System.out.println("Warning: data file not found, after some command we will create one");
		} catch (IOException e) {
			System.out.println("Error happen when loading data, try again!");
		} catch (ClassNotFoundException e) {
			System.out.println("File data is not valid! let we delete it, and try again");
			File file = new File(storageFile);
			file.delete();
		}
		
	}
	
	public void SaveData() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(storageFile);
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			
			outputStream.writeObject(queue);
			
			outputStream.close();
			fileOutputStream.close();
		}catch(FileNotFoundException e) {
			System.out.println("CANNOT save data, please try again!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * parse the rest of arguments then excecute command
	 * @param args
	 */
	public void ParseArguments(String[] args) {
		
		try {
			switch(args[0]) {
			case "-r": //read csv
				queue = new PriorityQueue(); //make new one! (clear old data)
				CSV.ReadAndPushToQueue(queue, args[1]);
				break;
			default:
				System.out.println("Command not found, try again!");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough argument to excecute command!");
		} catch (IOException e) {
			System.out.println("There is an error happen, please check your csv file or any input parameter");
		}
		
		SaveData();
		
	}
}
