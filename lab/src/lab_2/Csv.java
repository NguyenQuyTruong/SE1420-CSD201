/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Khả Thi
 */
public class Csv {
    Map<String, Integer> map;
	
	public Csv() {
		map = new LinkedHashMap<String, Integer>();
	}
    public void CheckAndUpdate(String tag){
        if(map.containsKey(tag)){
            map.put(tag, 1);
        }
        else{
            map.put(tag, map.get(tag)+1);
        }
    }
    public void SaveToFile(String path) throws IOException{
        FileWriter writer = new FileWriter(path);
        Map<String, Integer> result = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(
         Map.Entry::getKey, 
         Map.Entry::getValue, 
        (oldValue, newValue) -> oldValue, LinkedHashMap::new));;
         for (Map.Entry<String, Integer> entry : result.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            writer.append(key + "," + value+"\n");
        }
        writer.close();
    }
}
