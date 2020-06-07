/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

/**
 *
 * @author Khả Thi
 */
import java.io.*;
public class Csv {
    public static void ReadCsv(String path,PriorityQueue queue){
        String line ="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine()
            while(line = br.readLine() && line!=null){
                
            }
        }catch(FileNotFoundException e){
            System.out.println("File don.t exit!");
        }
    }
}
