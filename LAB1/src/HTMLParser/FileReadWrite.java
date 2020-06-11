/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author minhv
 */
public class FileReadWrite {
    HashMap<String, Integer> htmlTag = new HashMap<>();
    
    public static String readData(String fileName) {
	FileReader fileRead = null;
	BufferedReader read = null;
	StringBuilder htmlBody;
	try {
	    //create file reader
	    fileRead = new FileReader(fileName);
	    //create buffer reader
	    read = new BufferedReader(fileRead);
	    while (read.ready()) {
		htmlBody = read.readLine();
	    }
	} catch (Exception e) {
	    System.out.println("File not founded");
	} finally {
	    try {
		if (fileRead != null) {
		    fileRead.close();
		}
		if (read != null) {
		    read.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return htmlBody;
    }
}
