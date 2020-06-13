/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * this method use to write the map to the file
     * @param csvFile
     * @throws IOException
     */
    public void outputCSV(String csvFile) throws IOException {
	FileWriter fw = null;
	try {
	    fw = new FileWriter(csvFile);
	    //sort the map in descending order
	    Map<String, Integer> result = data.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		    .collect(Collectors.toMap(
			    Map.Entry::getKey,
			    Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	    //go though the map, read line by line and write to file
	    fw.append("Tag, Frequency\n");
	    for (Map.Entry<String, Integer> entry : result.entrySet()) {
		String line = String.format("%s, %d\n", entry.getKey(), entry.getValue());
		fw.append(line);
	    }
	} catch (IOException e) {
	    System.out.println("Can't write to file now!!");
	} finally {
	    if (fw != null) {
		fw.close();
	    }
	}
    }
}
