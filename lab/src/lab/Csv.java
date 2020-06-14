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
    public static void ReadCsv(String path,PriorityQueue queue) throws IOException{
        String line ="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
 
            while((line = br.readLine())!=null){
                String[] data = line.split(",");
                String email = data[0];
                String Spoint = data[1];
                Long point = Long.parseLong(Spoint);
                queue.InSert(email, point);
                
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println("File don.t exit!");
        }
    }
    public static void WriteToFile(PriorityQueue queue, String path) throws IOException{
        queue.Writefile(path);
    }
}