package vongockhang.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class will contain method to write to CSV file
 * @author skyho
 *	
 */
public class CSV {
	Map<String, Integer> data; //map data contains tag and count, FORMAT: {key: "script", value: 5} 
	
	public CSV() {
		data = new HashMap<String, Integer>(); //init hashmap 
	}
		
	/**
	 * 
	 * @param tag current tag that need to update count
	 */
	public void UpdateValue(String tag) {
		if (!data.containsKey(tag)) { //if not contain that tag, create new record
			data.put(tag, 1); //value 1 because this tag is found once before exist in the map
		}else { //if it exist, increase value
			data.put(tag, data.get(tag) + 1);
		}
	}
	
	/**
	 * @param data a Map contain this format: [{key: "html",value: 1},{key: "a", value: 5},...]
	 * @param path CSV file output path
	 * @throws IOException file not found
	 */	
	public void WriteCSV(Map<String, Integer> data, String csvPath) throws IOException {
		FileWriter csvFileWriter = new FileWriter(csvPath); //init FileWriter to write csv file
		
		// Add header of CSV file
		csvFileWriter.append("Tag");
		csvFileWriter.append(",");
		csvFileWriter.append("Count");
		csvFileWriter.append("\n");
		// ========================
		
		for(Map.Entry<String, Integer> entry : data.entrySet()) {
			csvFileWriter.append(String.format("%s,%d\n", entry.getKey(), entry.getValue())); 
			//String format {key: "html", value: 1} to raw string => "html,1\n" => append it to csv file
		}
		
		csvFileWriter.flush();
		csvFileWriter.close();
	}
}
