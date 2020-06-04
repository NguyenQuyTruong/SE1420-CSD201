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

	/**
	 * @param args
	 * args[0]: problem 1 or 2
	 * if problem 2: 
	 * 		+ args[1]: url of website
	 * 		+ args[2]: csv file path
	 */
	public static void main(String[] args) {
		int exitCode = new CommandLine(new Problem1()).execute(args);
		System.exit(exitCode);
		
	}

}
