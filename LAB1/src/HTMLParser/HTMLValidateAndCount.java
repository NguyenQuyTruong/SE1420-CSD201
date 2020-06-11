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
	if (isOpenTag(tag)) {
	    String[] separateTag = tag.split(" ");
	    if (separateTag.length == 1) {
		return tag;
	    } else {
		return separateTag[0] + ">";
	    }
	} else if (isCloseTag(tag)) {
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
	tag = tag.replace("<", "</");
	return tag;
    }

    /**
     * If it is contain in HTML return true, else return false. Khang explains
     * for me how to identify alone tag like <br>
     * Thanks for his helping
     *
     * @param tag
     * @param body
     * @return true or false
     */
    public boolean isAloneTag(String tag, String body) {
	tag = converToCloseTag(tag);
	return !body.contains(tag);
    }
}
