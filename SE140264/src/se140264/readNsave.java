/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se140264;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ACER
 */
public class readNsave {
    public void readDataToQueue(String path, DoubleLinkedList dll) throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = null;

        do {
            try {
                line = bufferedReader.readLine();

                
                String[] arr = line.split(","); 
                int point = Integer.parseInt(arr[1].trim());

                dll.add(arr[0], point);

            } catch (Exception e) {
                
            }

        } while (line != null);
    }
    public void writeData(String filepath, DoubleLinkedList dll) throws IOException{
        FileWriter writer = new FileWriter(filepath);
        
        writer.append("Name, Point\n");
        
        DoubleLinkedList.node testing = dll.head;
        
        while(testing != dll.tail){
            writer.append(testing.Name + ", " + testing.point + "\n");
            testing = testing.next;
        }
        
        writer.flush(); 
        writer.close();
    }
}
