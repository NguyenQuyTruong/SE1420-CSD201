package vongockhang.lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class will contain method to write to CSV file
 * @author skyho
 *	
 */
public class CSV {
	Map<String, Integer> data; //map data contains tag and count, FORMAT: {key: "script", value: 5} 
	
	public CSV() {
		data = new LinkedHashMap<String, Integer>(); //init hashmap 
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
	public void WriteCSV(String csvPath) throws IOException {
		FileWriter csvFileWriter = new FileWriter(csvPath); //init FileWriter to write csv file
		final Map<String, Integer> sortedByFrequences = data.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		//this will sort the HashMap by values, result is turn it to LinkedHashMap (LinkedHashMap has Order)
		
		// Add header of CSV file
		csvFileWriter.append("Tag");
		csvFileWriter.append(",");
		csvFileWriter.append("Frequence");
		csvFileWriter.append("\n");
		// ========================
		
		for(Map.Entry<String, Integer> entry : sortedByFrequences.entrySet()) {
			String rawData = String.format("%s,%d\n", entry.getKey(), entry.getValue());
			System.out.print(rawData);
			csvFileWriter.append(rawData); 
			//String format {key: "html", value: 1} to raw string => "html,1\n" => append it to csv file
		}
		
		csvFileWriter.flush();
		csvFileWriter.close();
	}
}
