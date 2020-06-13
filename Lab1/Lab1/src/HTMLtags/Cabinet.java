/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author nhoxr
 */
public class Cabinet {

    static FileDAO file = new FileDAO();
    Stack stack = new Stack(500);

    /**
     * this method use to check the tag is open or not
     *
     * @param tag
     * @return true or false if the string input have < or </
     */
    private boolean checkTagOpen(String tag) {
	return (tag.contains("<") && !tag.contains("</"));
    }

    /**
     * this method use to check the tag have close tag or not by convert it to a
     * normal close tag and compare it to every word in HTML body
     *
     * @param tag
     * @param htmlBody
     * @return true if converted tag not in HTML body
     */
    private boolean checkAloneTag(String tag, String htmlBody) {
	tag = tag.replace("<", "</");
	return !htmlBody.contains(tag);
    }

    /**
     * this method use to compare input tag and the tag in stack
     *
     * @param tag
     * @param tagInStack
     * @return true if the tag is the close tag
     */
    private boolean compare2Tag(String tag, String tagInStack) {
	tag = tag.replace("/", "");
	return tag.equals(tagInStack);
    }

    /**
     * some special tag like <a ...>, <img ...> don't have the close / character
     * so this method use to convert them to a normal tag => <a>, <img>,...
     *
     * @return normail Tag
     */
    private String convertToTag(String tag) {
	String[] splitSpace = tag.split(" ");
	if (splitSpace.length == 1) {
	    return tag;
	} else {
	    String normalTag = splitSpace[0] + '>';
	    return normalTag;
	}
    }

    /**
     * this method use to convert special tag like <br> to </br> and use this
     * convert String compare with HTML body String
     *
     * @param tag
     * @return close tag String
     */
    private boolean alongTag(String tag, String htmlBody) {
	String closeTag = tag.replace("<", "</");
	return !htmlBody.contains(closeTag);
    }

    /**
     * this method use to scan all HTML body to find out which characters is tag
     * and it can also check some special tag
     *
     * @param htmlBody
     */
    private void analysisHTML(String htmlBody) {
	String tag = "";
	boolean validTag = false;
	for (int i = 0; i < htmlBody.length(); i++) {
	    if (htmlBody.charAt(i) == '<') {
		tag = "<";
		validTag = true;
	    } else if ((htmlBody.charAt(i) != '>' && htmlBody.charAt(i) != ' ')
		    && validTag) {

		if (!(Character.isLetterOrDigit(htmlBody.charAt(i)))
			&& (htmlBody.charAt(i) != '!') //check if the tag maybe the comment tag
			&& (htmlBody.charAt(i) != '/')) { //check if the tag is the close tag or not
		    validTag = false;
		}
		tag = tag + htmlBody.charAt(i);
	    } else if ((htmlBody.charAt(i) != '>' || htmlBody.charAt(i) != ' ')
		    && validTag) {
		tag = tag + '>';
		validTag = false; //enough char to create a tag so we turn this of =))
		handlingTag(tag, htmlBody);
	    }
	}
    }

    /**
     * this method use to handling tag from HTML body, it will check the tag is
     * open or close and depend on it to push to stack or pop of stack, this
     * method also send tag to file
     *
     * @param tag
     * @param htmlBody
     */
    private void handlingTag(String tag, String htmlBody) {
	tag = tag.toLowerCase();

	if (!tag.contains("</") && alongTag(tag, htmlBody) && !tag.contentEquals("<!doctype>")) {
	    file.setTagValue(tag);
//	    System.out.println(tag);
	} else {
	    tag = convertToTag(tag);
	    if (!tag.contains("</")) {
		stack.push(tag);
//		System.out.println(tag);
	    } else if (compare2Tag(tag, stack.top())) {
		file.setTagValue(stack.top());
		stack.pop();
//		System.out.println(tag);
	    }
	}
    }

    public static void main(String[] args) throws IOException {
	Cabinet cage = new Cabinet();
//	FileDAO file = new FileDAO();
	Stack stack = new Stack(100);
//	stack.push("<div>");
//	stack.push("<a>");
//	stack.push("<h1>");
//	stack.push("<h2>");
//	stack.pop();
//	System.out.println(stack.top());
	String body = downloadWebsite("https://vnexpress.net");
	cage.analysisHTML(body);
	
	file.outputCSV();
//	System.out.println(body);

    }

    /**
     * this method use to download the whole HTML site depend on URL input and
     * the body will be converted to String
     *
     * @param siteUrl
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    public static String downloadWebsite(String siteUrl) throws MalformedURLException, IOException {
	HttpURLConnection connection = (HttpURLConnection) new URL(siteUrl).openConnection();
	connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
	StringBuilder htmlBody = new StringBuilder();
	try {
	    InputStream inputstream = connection.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));

	    String line;
	    while ((line = reader.readLine()) != null) {
		htmlBody.append(line);
	    }
	    reader.close();
	} catch (IOException e) {
	    System.out.println("Can't open the link!!");
	}
	return htmlBody.toString();
    }
}
