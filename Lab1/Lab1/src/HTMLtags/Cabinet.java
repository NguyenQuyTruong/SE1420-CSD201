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
     * @param tag
     * @return true or false if the string input have < or </
     */
    private boolean checkTagOpen(String tag) {
	return (tag.contains("<") && !tag.contains("</"));
    }
}
