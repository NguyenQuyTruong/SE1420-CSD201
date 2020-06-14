/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author minhv
 */
public class FileProcessHTML {

    /**
     * Create an HTMLTag for easy use
     */
    class HTMLTag implements Comparable<HTMLTag> {
	//field
	private String tag;
	private int count;
	/**
	 * Default constructor
	 */
	public HTMLTag() {
	    tag = "";
	    count = 0;
	}

	/**
	 * Constructor for get parameters
	 * @param tag
	 * @param count 
	 */
	public HTMLTag(String tag, int count) {
	    this.tag = tag;
	    this.count = count;
	}
	//getter setter
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

	/**
	 * Compare method use for sorting an list
	 * @param tag
	 * @return integer number
	 */
	@Override
	public int compareTo(HTMLTag tag) {

	    if (count > tag.getCount()) {
		return -1;
	    } else if (count == tag.getCount()) {
		return 0;
	    } else {
		return 1;
	    }
	}
    }

    private static HashMap<String, HTMLTag> list;

    public FileProcessHTML() {
	list = new HashMap<>();
    }

    public static String downloadWebsite(String siteUrl) throws MalformedURLException, IOException {
	HttpURLConnection connection = (HttpURLConnection) new URL(siteUrl).openConnection();
	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
	BufferedReader buffer = null;
	//because html file don't have any specific to split String like csv or txt file
	//choice StringBuilder is a suitable option and in gg to read an html
	//from URL also use StringBuilder
	StringBuilder htmlBody = null;
	try {
	    InputStream inputstream = connection.getInputStream();
	    buffer = new BufferedReader(new InputStreamReader(inputstream));
	    htmlBody = new StringBuilder();
	    String line;
	    while ((line = buffer.readLine()) != null) {
		htmlBody.append(line);
		htmlBody.append("\n");
	    }
	} catch (IOException e) {
	    System.out.println("Can't open the link!!");
	} finally {
	    if (buffer != null) {
		buffer.close();
	    }
	}
	//final result is like 
	//<!DOCTYPE html><html lang="en">    <head>        <meta charset="UTF-8">
	return htmlBody.toString();
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

    public static HashMap<String, HTMLTag> sortData() {
	List<Map.Entry<String, HTMLTag>> listTag
		= new LinkedList<Map.Entry<String, HTMLTag>>(list.entrySet());

	// Sort the list 
	Collections.sort(listTag, new Comparator<Map.Entry<String, HTMLTag>>() {
	    public int compare(Map.Entry<String, HTMLTag> o1,
		    Map.Entry<String, HTMLTag> o2) {
		return (o1.getValue()).compareTo(o2.getValue());
	    }
	});

	// put data from sorted list to hashmap  
	HashMap<String, HTMLTag> temp = new LinkedHashMap<String, HTMLTag>();
	for (Map.Entry<String, HTMLTag> aa : listTag) {
	    temp.put(aa.getKey(), aa.getValue());
	}
	return temp;
    }

    public static void writeData(String fileName) {
	HashMap<String, HTMLTag> listTag = sortData();
	//prevent exception
	if (listTag.isEmpty()) {
	    System.out.println(listTag.isEmpty());
	    return;
	}
	//create file write
	PrintWriter writeFile = null;
	try {
	    writeFile = new PrintWriter(fileName);
	    //create loop to read all list and write to File
	    writeFile.println("Tag, Frequency");
	    Set key = listTag.keySet();
	    Iterator it = key.iterator();
	    while (it.hasNext()) {
		writeFile.println(listTag.get(it.next()));
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
}
