
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class CSV {
    public void readDataToQueue(String path,DoublyLinkedList lk) throws FileNotFoundException{
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line = null;
        do {            
            try {
                line = bf.readLine();
                
                String[] arr=line.split(",");//arr[0] se la gmail , arr[1] se la point
                int point=Integer.parseInt(arr[1].trim());
                
                lk.insert(point,arr[0]);
                
            } catch (Exception e) {
            }
        } while (line!=null);
    }
    
    public void writeData(String filepath,DoublyLinkedList dk )throws Exception{
        FileWriter writer = new FileWriter(filepath);
        writer.append("Point,Email\n");
        
        DoublyLinkedList.Node tmp =dk.header;
        
        while (tmp!=dk.tailer) {            
            writer.append(tmp.email)
        }
    }
    
}
