/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author nhoxr
 */
public class FileDAO {
    Map<String, Integer> data = new LinkedHashMap<>();
    
    public void setTagCount(String tag) {
	if (!data.containsKey(tag)) { //if the tag not exist, put it to hashmap and set value 1
	    data.put(tag, 1);
	} else { //if the tag exist, get the exist value +1
	    data.put(tag, data.get(tag) + 1);
	}
    }
}
