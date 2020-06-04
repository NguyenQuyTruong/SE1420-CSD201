package problem1;

public class Problem1{	
	
	PriorityQueue queue;
	public Problem1() {
		queue = new PriorityQueue();
	}
	
	
	
	
	public void ParseArguments(String[] args) {
		
		try {
			switch(args[0]) {
			case "-r": //read csv
				
			default:
				System.out.println("Command not found, try again!");
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough argument to excecute command!");
		}
		
		
	}
}
