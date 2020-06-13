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

    private FileReadWrite file = new FileReadWrite();
    //Create an stack
    private Stack stack = new Stack();

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
     * false, else return true. Khang explains for me how to identify alone tag
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
	//htmlString.contains(tag) is true when it have close tag -> not alone tag
	//else false -> it is alone tag
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
	System.out.println("Compare tag function: " + tag.equals(tagInStack));
	return tag.equals(tagInStack);
    }

    /**
     * Spit each character and merge it to a tag. Using regex expression to
     * verify each character. If it a tag put it to checkTag method to verify it
     * open or close or alone tag
     *
     * @param htmlString
     */
    public void splitTag(String htmlString) {
	String tag = "";
	boolean isStillValid = true;
	//htmlString.length() use to get length of string also include space
	for (int i = 0; i < htmlString.length(); i++) {
	    //check is "<" or not
	    if (htmlString.charAt(i) == '<') {
		//continue to read this String and isStillValid is the break point of loop
		for (int j = i; j < htmlString.length() && isStillValid == true; j++) {
		    if (regexCheckTag(Character.toString(htmlString.charAt(j))) && htmlString.charAt(j) != '>') {
			//merge each character to a tag
			tag += htmlString.charAt(j);
		    } else {
			//stop the loop
			isStillValid = false;
			//make tag close
			tag += '>';
//			System.out.println("Tag in slipTag: " + tag);
			//result tag from <!DOCTYPE html> or comment tag
			if (!tag.equals("<>")) {
			    System.out.println("Tag in slipTag after compare '<>': " + tag);
			    //it's time for check tag
			    checkTag(tag, htmlString);
			}
			//reset String tag to none
			tag = "";
			j--;
			i = j;
		    }
		}
	    } else {
		//reset isStillValid to valid for run the loop
		isStillValid = true;
	    }
	}
    }

    /**
     * Check an tag is valid or not and than add to list in File to write to csv
     * File
     *
     * @param tag
     * @param htmlString
     */
    public void checkTag(String tag, String htmlString) {
	String tagCompare = "";
	boolean isValid;
	if (isOpenTag(tag)) {
	    if (!isAloneTag(tag, htmlString)) {
		System.out.println("Push: " + tag);
		stack.push(tag);
	    } else {
		System.out.println("Tag: " + tag + " isValid: " + isAloneTag(tag, htmlString));
		file.updateValue(tag);
	    }
	} else if (isCloseTag(tag)) {
	    tagCompare = stack.top();
	    isValid = compareTag(tag, tagCompare);
	    if (isValid) {
		System.out.println("Pop: " + tag);
		file.updateValue(stack.pop());
	    }
	}
    }

    /**
     * Check each character base on regex expression start from a to z, A to Z,
     * 0 to 9 and include '/' also + for check not empty (space), if match
     * return true else false
     *
     * @param character
     * @return true or false
     */
    public static boolean regexCheckTag(String character) {
	return character.matches("^[a-zA-Z0-9'/''<']+$");
    }

    public void manage(String csvFile, String fileName) {
	try {
	    String htmlString = FileReadWrite.readData(fileName);
	    splitTag(htmlString);
//	    FileReadWrite.writeData(csvFile);
	    FileReadWrite.display();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
