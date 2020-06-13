
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liemn
 */
public class csv {
    public void readToQueue(String pathString, DoubleLinkList ls) throws 
            FileNotFoundException{
      //  DoubleLinkList ls = new DoubleLinkList();
        BufferedReader bf = new BufferedReader(new FileReader("user.csv"));
        String line ="";
        
        do {            
            try {
                line = bf.readLine();
                String [] arr = line.split(",");
                int point = Integer.parseInt(arr[1]);
                ls.insert(arr[0], point);
            } catch (Exception e) {
            }
        } while (true);
    }
    public void writeData(String filePath, DoubleLinkList ls){
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.append("Email, Point\n");
            DoubleLinkList.Node tmp = ls.head; // chay tu head
            while(tmp!= ls.tail){
                writer.append(tmp.email + "," + tmp.point + "\n");
                tmp = tmp.right;
                writer.flush(); // save file
                writer.close(); // close file
            }
        } catch (IOException e) {
        }       
    }
}
