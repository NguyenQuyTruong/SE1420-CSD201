/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author nds72
 */
public class csv {


//    public void readDataToQueue(String path, DoublyLinkedList lk) throws FileNotFoundException {
////        DoublyLinkedList lk = new DoublyLinkedList();
//
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
//        String line = null;
//
//        do {
//            try {
//                line = bufferedReader.readLine();
//
//                //gmail,5
//                String[] arr = line.split(","); //arr[0] => gmail, arr[1] => point
//                int point = Integer.parseInt(arr[1].trim());
//
//                lk.insert(arr[0], point);
//
//            } catch (Exception e) {
//                // bo qua het loi
//            }
//
//        } while (line != null);
//    }
//    
//    public void writeData(String filepath, DoublyLinkedList dk) throws IOException{
//        FileWriter writer = new FileWriter(filepath);
//        
//        writer.append("Email, Point\n");
//        
//        DoublyLinkedList.Node tmp = dk.head; //chay tu head
//        
//        while(tmp != dk.tail){
//            writer.append(tmp.email + "," + tmp.point + "\n");
//            tmp = tmp.right;
//        }
//        
//        writer.flush(); //luu 
//        writer.close(); //dong file
//       }
}
/*
//        lab.readDataQueue("C:\\Users\\nds72\\Desktop\\user.csv", doublyLinkedList);
//        doublyLinkedList.print();
*/
/*
//    -r  D:\\SE140959\\SE1420-CSD201\\Lab201\\dist\\user.csv -s D:\\SE140959\\SE1420-CSD201\\Lab201\\dist\\test.csv
*/