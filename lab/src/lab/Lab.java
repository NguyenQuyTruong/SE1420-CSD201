/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Khả Thi
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
           PriorityQueue queue;
           String filename;
    public void Save() throws IOException {
		try {
			FileOutputStream FOS = new FileOutputStream(filename);
			ObjectOutputStream OS = new ObjectOutputStream(FOS);
			
			OS.writeObject(queue);
			
			OS.close();
			FOS.close();
		}catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e) {
			e.printStackTrace();
		}
	}
    public static void main(String[] args) {
        // TODO code application logic here
 
        
    }
    
}
