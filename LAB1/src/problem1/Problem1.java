package problem1;

import java.io.IOException;

public class Problem1{	
	
	PriorityQueue queue;
	public Problem1() {
		queue = new PriorityQueue();
	}
	
	
	
	
	public void ParseArguments(String[] args) {
		
		try {
			switch(args[0]) {
			case "-r": //read csv
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
		
		
	}
}
