package problem1;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(description = "Problem 1 Solver", 
name = "Problem 1", 
mixinStandardHelpOptions = true,
version = "Problem 1.0")
public class Problem1 implements Callable<Integer>{
	@Option(names = {"-r"}, description = "Read CSV file")
	String csvFilePath;
	
	public Problem1() {
		PriorityQueue queue = new PriorityQueue();
		
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(csvFilePath);
		return 0;
	}
}
