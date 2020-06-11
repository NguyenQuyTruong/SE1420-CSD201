/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author KHAM
 */
public class Ex2Manager {

    MyStack ms = new MyStack();
    ArrayList arr = new ArrayList();
    final String opening = "<";

    public void inputStack(String content) {
        for (char c : content.toCharArray()) {
            if (opening.indexOf(c) != -1) {
            }
        }
        
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        Ex2Manager ex2 = new Ex2Manager();
        String line = "";
        String content = "";
        URL ur = new URL("https://vnexpress.net/");

        HttpsURLConnection urlc = (HttpsURLConnection) ur.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

        while ((line = br.readLine()) != null) {
            content += line;
        }
        System.out.print(content);
        ex2.inputStack(content);
    }
}
