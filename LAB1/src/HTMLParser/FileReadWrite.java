/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
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
		return -1;
	    } else if (count == tag.getCount()) {
		return 0;
	    } else {
		return 1;
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
