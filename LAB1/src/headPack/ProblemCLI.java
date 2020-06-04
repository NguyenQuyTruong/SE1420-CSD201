package headPack;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(description = "Problem Solver by Vo Ngoc Khang", 
name = "1", 
mixinStandardHelpOptions = true,
version = "Problem 1.0")
public class ProblemCLI implements Callable<Integer> {
	@Option(names = {"-r"}, description = "Read CSV file")
	String csvFilePath;
	
	@Override
	public Integer call() throws Exception {
		System.out.println("Hello");
		return 0;
	}

}
