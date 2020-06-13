
import HTMLtags.Exercise2;
import mobileGame.Exercise1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nhoxr
 */
public class main {

    /**
     * check input String for CLI check
     * @param arr
     * @param value
     * @return result
     */
    private static int contains(String[] arr, String value) {
	int result = -1;

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i].equals(value)) {
		result = i;
	    }
	}
	return result;
    }

    private static String CLIcheck(String[] args) {

    }

    public static void main(String[] args) {
	Exercise1 e1 = new Exercise1();
	Exercise2 e2 = new Exercise2();

    }
}
