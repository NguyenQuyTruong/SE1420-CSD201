/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Khả Thi
 */
public class DownWeb {
    /**
	 * Down web and save it into path
	 * @param url,Path
	 */
    public static void Download(String url) throws MalformedURLException, IOException{
       URL urld = new URL(url);
       String Path;      
      try(
         BufferedReader reader =  new BufferedReader(new InputStreamReader(urld.openStream()));         
         BufferedWriter writer = new BufferedWriter(new FileWriter("page.html"));       
      )  {      
         String line;
         while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
         }            
         System.out.println("Page downloaded.");
      } 

                 
    }
}
