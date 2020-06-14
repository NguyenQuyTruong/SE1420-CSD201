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
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 *
 * @author Khả Thi
 */
public class DownWeb {
    public static void Download(String url) throws MalformedURLException, IOException{
       URL urld = new URL(url);
       String Path;
       BufferedReader reader =  new BufferedReader(new InputStreamReader(url.openStream()));
       BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\page.html"));
    }
    
}
