/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author nhoxr
 */
public class FileDAO {

    HashMap<String, Integer> data;

    public FileDAO() {
	data = new HashMap<>();
    }

    /**
     * this method use to receive tag input and put it to linkedHashMap and
     * count the time it appear.
     *
     * @param tag
     */
    public void setTagValue(String tag) {
	if (!data.containsKey(tag)) { //if the tag not exist, put it to hashmap and set value 1
	    data.put(tag, 1);
	} else { //if the tag exist, get the exist value +1
	    data.put(tag, data.get(tag) + 1);
	}
    }

    public void outputCSV() {

	Map<String, Integer> result = data.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(Collectors.toMap(
			Map.Entry::getKey,
			Map.Entry::getValue,
			(oldValue, newValue) -> oldValue, LinkedHashMap::new));
	for (Map.Entry<String, Integer> entry : result.entrySet()) {
	    System.out.println(entry.getKey() + ", " + entry.getValue());
	    //String format {key: "html", value: 1} to raw string => "html,1\n" => append it to csv file
	}
    }
}
