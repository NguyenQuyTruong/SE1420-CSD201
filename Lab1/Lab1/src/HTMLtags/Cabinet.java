/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

/**
 *
 * @author nhoxr
 */
public class Cabinet {

    /**
     * this method use to check the tag is open or not
     *
     * @param tag
     * @return true or false if the string input have < or </
     */
    private boolean checkTagOpen(String tag) {
	return (tag.contains("<") && !checkTagClose(tag));
    }

    private boolean checkTagClose(String tag) {
	return tag.contains("</");
    }

    /**
     * this method use regex to check the string input is the tag or not
     * @param tag
     * @return true or false
     */
    private boolean checkTagByRegex(String tag) {
	return tag.matches("^['<''/'A-Za-z0-9]+$");
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
    
    private void analysisHTML(String htmlBody) {
	String tag = "";
	boolean validTag = false;
	for (int i = 0; i < htmlBody.length(); i++) {
	    if (htmlBody.charAt(i) == '<') {
		tag = "<";
		validTag = true;
	    } else if ((htmlBody.charAt(i) != '>' && htmlBody.charAt(i) != ' ') && validTag) {
		
	    }
	    
	}
    }
}
