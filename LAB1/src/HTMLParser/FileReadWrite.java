/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author minhv
 */
public class FileReadWrite {

    class HTMLTag implements Comparable<HTMLTag> {

	private String tag;
	private int count;

	public HTMLTag() {
	    tag = "";
	    count = 0;
	}

	public HTMLTag(String tag, int count) {
	    this.tag = tag;
	    this.count = count;
	}

	public String getTag() {
	    return tag;
	}

	public void setTag(String tag) {
	    this.tag = tag;
	}

	public int getCount() {
	    return count;
	}

	public void setCount(int count) {
	    this.count = count;
	}

	@Override
	public String toString() {
	    return tag + ", " + count;
	}

	@Override
	public int compareTo(HTMLTag tag) {

	    if (count > tag.getCount()) {
		return 1;
	    } else if (count == tag.getCount()) {
		return 0;
	    } else {
		return -1;
	    }
	}
    }

    private static HashMap<String, HTMLTag> list;

    public FileReadWrite() {
	list = new HashMap<>();
    }

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
		htmlBody.append(line).append("\n");
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

    public void updateValue(String tag) {
	HTMLTag hTMLTag = new HTMLTag(tag, 1);
	if (list.isEmpty()) {
	    list.put(tag, hTMLTag);
	} else {
	    if (list.containsKey(tag)) {
		list.get(tag).setCount(list.get(tag).getCount() + 1);
	    } else {
		list.put(tag, hTMLTag);
	    }
	}
    }

    public static void writeData(String fileName) {
	//prevent exception
	if (list.isEmpty()) {
	    System.out.println(list.isEmpty());
	    return;
	}
	//create file write
	FileWriter writeFile = null;
	try {
	    writeFile = new FileWriter(fileName);
	    //create loop to read all list and write to File
	    writeFile.write("Tag, Frequency");
	    Set key = list.keySet();
	    Iterator it = key.iterator();
	    while (it.hasNext()) {
		writeFile.write(it.next().toString());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (writeFile != null) {
		    writeFile.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }

    public static void display() {
	Set key = list.keySet();
	Iterator it = key.iterator();
	while (it.hasNext()) {
	    System.out.println(list.get(it.next()));
	}
    }
}
