/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author ADMIN
 */
public class FileDao {
    static void readFile(SortLinkedList list,String filename) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                return;
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String detail = "";
            while ((detail = br.readLine()) != null) {
                String [] result=detail.split(",");
                if(!result[0].equalsIgnoreCase("Email")){
                    list.add(result[0], Integer.parseInt(result[1]));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }
    public static void writeFile(SortLinkedList list,String filename){
        list.writeFile(filename);
    }
}
