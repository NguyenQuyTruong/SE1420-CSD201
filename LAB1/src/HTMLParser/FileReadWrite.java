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
	BufferedReader buffer = null;
	//because html file don't have any specific to split String like csv or txt file
	//choice StringBuilder is a suitable option and in gg to read an html
	//from URL also use StringBuilder
	StringBuilder htmlBody = null;
	try {
	    //create file reader
	    fileRead = new FileReader(fileName);
	    //create buffer reader
	    buffer = new BufferedReader(fileRead);
	    htmlBody = new StringBuilder();
	    String line;
	    while ((line = buffer.readLine()) != null) {
		//link each line together
		htmlBody.append(line);
	    }
	} catch (Exception e) {
	    System.out.println("File not founded");
	} finally {
	    try {
		if (fileRead != null) {
		    fileRead.close();
		}
		if (buffer != null) {
		    buffer.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	//final result is like 
	//<!DOCTYPE html><html lang="en">    <head>        <meta charset="UTF-8">
	return htmlBody.toString();
    }
}
