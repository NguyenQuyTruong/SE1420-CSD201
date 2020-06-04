/**
 * 
 */
package headPack;

import picocli.CommandLine;
import problem1.Problem1;
import problem2.Problem2;

/**
 * @author vo ngoc khang
 *
 */
public class Main {

	public static void main(String[] args) {
		int exitCode = new CommandLine(new ProblemCLI()).execute(args);
		System.exit(exitCode);
		
	}

}
