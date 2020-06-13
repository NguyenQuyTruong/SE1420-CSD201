/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenLab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class CSV {
    Map<String, Integer> csv;
    
public CSV() {
        csv = new LinkedHashMap<>();
    }
    public void countTag(String tag) {
        if (csv.containsKey(tag) == false) {
            csv.put(tag, 1);
        } else {
            csv.put(tag, csv.get(tag) + 1);
        }
    }
public void print() {
        for (Map.Entry<String, Integer> entry : csv.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("key: " + key + " value: " + value);
        }
    }
public void sorrt(String file) throws FileNotFoundException {

        Map<String, Integer> sortedByFrequences = csv.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        File f = new File(file);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag, Frequences\n");
        for (Map.Entry<String, Integer> entry : sortedByFrequences.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            pw.println(key + "," + value);
        }
}
}
