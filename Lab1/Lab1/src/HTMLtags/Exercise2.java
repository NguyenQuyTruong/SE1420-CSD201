/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

import java.io.BufferedReader;
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
public class Exercise2 {

    static FileDAO file = new FileDAO();
    Stack stack = new Stack(500);

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
		validTag = false;
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

    public void inputCLI(String url, String fileName) throws IOException {
	try {
	    String body = downloadWebsite(url);
	    analysisHTML(body);
	    file.outputCSV(fileName);
	} catch (IOException e) {
	    System.out.println("Can't write to file =(((");
	} catch (Exception e) {
	    System.out.println("Can't read the URL");
	}
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
    public static String downloadWebsite(String siteUrl) throws MalformedURLException, IOException{
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
