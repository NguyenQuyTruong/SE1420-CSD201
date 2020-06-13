/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenLab2;

import java.util.LinkedHashMap;
import java.util.Map;

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





}
