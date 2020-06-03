/**
 * 
 */
package vongockhang.lab1;

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
		try {
			switch (Integer.parseInt(args[0])) {
			case 1:
				Problem1 problem1 = new Problem1();
				break;
			case 2:
				if (args.length < 3) {
					throw new IllegalArgumentException("Not enough argument for problem 2");
				}
				Problem2 problem2 = new Problem2(args[1], args[2]);
				break;
			default:
				break;	
			}
		}catch(NumberFormatException e) {
			System.out.println("Error at ARGS[0]: Please choose problem number 1 or 2 ONLY!");
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
