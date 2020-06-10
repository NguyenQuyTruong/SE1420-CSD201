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
    private boolean isOpenTag(String tag) {
	return tag.contains("<") && !tag.contains("</");
    }
    
    private boolean isCloseTag(String tag) {
	
    }
    
    private String startTag(String tag) {
	if (tag.contains("<") && tag.contains(">") && !tag.contains(" ") && !tag.contains("</")) {
	    
	}
    }
}
