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
     * @param tag
     * @return true or false
     */
    private boolean isOpenTag(String tag) {
	//if it contain 
	return tag.contains("<") && !tag.contains("</");
    }
    
    private boolean isCloseTag(String tag) {
	return tag.contains("</");
    }
    
    public String checkTag(String tag) {
	String tagResult = "";
	if (isOpenTag(tag)) {
	    String[] separateTag = tag.split(" ");
	    if (separateTag.length == 1) {
		return tag;
	    } else {
		return separateTag[0] + ">";
	    }
	}else if (isCloseTag(tag)) {
	    return tag;
	}
	return null;
    }
    
    public 
}
