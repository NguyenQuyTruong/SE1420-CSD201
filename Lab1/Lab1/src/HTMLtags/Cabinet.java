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
     *
     * @param tag
     * @return true or false
     */
    private boolean checkTagByRegex(String tag) {
	return tag.matches("^['<''/'A-Za-z0-9]+$");
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
    private boolean existAlongTag(String tag, String htmlBody) {
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
		System.out.println(tag);
	    }
	}
    }

//    private void
    public static void main(String[] args) {
	Cabinet cage = new Cabinet();
	String body = "<a>Huy</a>....<h2><!--huy-->";
	String tag = "<b>";
	cage.existAlongTag(tag, body);
//	System.out.println(cage.existAlongTag(tag, body));
//	cage.analysisHTML(body);
	System.out.println(cage.compare2Tag("</a>", "<a>"));
    }
}
