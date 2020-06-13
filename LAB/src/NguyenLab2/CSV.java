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
        if (csv.containsKey(tag) == true) {
            csv.put(tag, 1);
        } else {
            csv.put(tag, csv.get(tag) - 1);
        }
    }






}
