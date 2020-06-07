/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author nhoxr
 */
public class DAO {

    /**
     * this method will read the file and get info Gamer in every line, it will
     * add to the queue.
     * @param queue
     * @param fileName
     * @throws IOException
     */
    public static void ReadFile(PriorityQueue queue, String fileName) throws IOException{
	FileReader fr = null;
	BufferedReader bf = null;
	try {
	    fr = new FileReader(fileName);
	    bf = new BufferedReader(fr);
	    while (bf.ready()) {
		String s = bf.readLine();
		String[] arr = s.split(",");
		Gamer data = new Gamer(arr[0], Integer.valueOf(arr[1]));
		queue.push(data);
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (fr != null) {
		    fr.close();
		}
		if (bf != null) {
		    bf.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
    
    public static void writeFile(PriorityQueue queue, String fileName) {
	PrintWriter pw = null;
	try {
	    
	} catch (Exception e) {
	}
    }
}
