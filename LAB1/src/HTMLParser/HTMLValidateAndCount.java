/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

/**
 *
 * @author minhv
 */
public class HTMLValidateAndCount {

    /**
     * Check is open tag or not
     *
     * @param tag
     * @return true or false
     */
    private boolean isOpenTag(String tag) {
	//if it contain "<" and don't contain "</"
	return tag.contains("<") && !tag.contains("</");
    }

    /**
     * Check is close tag or not
     *
     * @param tag
     * @return true or false
     */
    private boolean isCloseTag(String tag) {
	//if it contain "</"
	return tag.contains("</");
    }

    /**
     * If it is open tag and have any information after that like href, id,
     * class,... Remove it and then add ">" after name tag then return it Else
     * close tag return it
     *
     * @param tag
     * @return an open tag or a close tag
     */
    public String checkTag(String tag) {
	//check tag is open or close
	if (isOpenTag(tag)) {
	    //slipt an tag
	    String[] separateTag = tag.split(" ");
	    //an tag without next information inside this tag
	    if (separateTag.length == 1) {
		return tag;
	    } else {
		//put ">" to tag a tag
		return separateTag[0] + ">";
	    }
	} else if (isCloseTag(tag)) {	//is an close tag
	    return tag;
	}
	return null;
    }

    /**
     * Convert an open tag to close tag
     *
     * @param tag
     * @return tag
     */
    public String converToCloseTag(String tag) {
	tag = tag.replace("<", "</");	//replace "<" to "</"
	return tag;
    }

    /**
     * If it (in status close tag after converted) is contain in HTML return
     * true, else return false. Khang explains for me how to identify alone tag
     * like <br>
     * Thanks for his helping
     *
     * @param tag
     * @param htmlString
     * @return true or false
     */
    public boolean isAloneTag(String tag, String htmlString) {
	tag = converToCloseTag(tag);	//convert to close tag
	return !htmlString.contains(tag);	//compare tag in the HTMl
    }

    /**
     * Compare two tag one is open and one is close Convert open to close for
     * comparing
     *
     * @param tag
     * @param tagInStack
     * @return true or false
     */
    public boolean compareTag(String tag, String tagInStack) {
	//convert open tag to close tag
	tagInStack = converToCloseTag(tagInStack);
	//return an compare if equal return true else false
	return tag.equals(tagInStack);	
    }
    
    /**
     * 
     * @param htmlString 
     */
    public void seperateTag(String htmlString) {
	String tag = "";
	boolean isStillValid = true;
	//htmlString.length() use to get length of string also include space
	for (int i = 0; i < htmlString.length(); i++) {
	    //check is "<" or not
	    if (htmlString.charAt(i) == '<') {
		//continue to read this String
		for (int j = i; j < htmlString.length() || isStillValid == false; j++) {
		    if (regexCheckTag(Character.toString(htmlString.charAt(i)))) {
			tag += htmlString.charAt(i);
		    } else {
			//stop the loop
			isStillValid = false;
			//make tag close
			tag += ">";
			i=j;
		    }
		}
	    } else {
		//it's time for check tag
		checkTag(tag);
	    }
	}
    }
    
    public void checkTag(String tag, String htmlString) {
	
    }
    
    public static boolean regexCheckTag(String character) {
	return character.matches("^[a-zA-Z0-9'/']+$");
    }
}
