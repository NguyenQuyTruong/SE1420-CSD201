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
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author KHAM
 */
public class Ex2Manager {

    MyStack ms = new MyStack();
    int count = 0;
    final char opening = '<';
    final char closing = '>';
//    final String space = " ";
//    final String Mark = "/";
//    final String Mark2 = "!";

    public void inputStack(String content) {
        char c[] = content.toCharArray();
        String tagString = "";
        for (int i = 0; i < c.length; i++) {
            tagString = "";
            if(Character.compare(c[i], opening) == 0){
                tagString += c[i];
                for(int j = 1; j < c.length - i; j++){
                    if((c[i + j] >= 'A' && c[i + j] <= 'Z') || (c[i + j] >= 'a' && c[i + j] <='z')){
                        tagString += c[i + j];
                    } 
                    else{
                        break;
                    }
                }
                tagString += closing;
                ms.push(tagString);
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        // Test 
        Ex2Manager ex2 = new Ex2Manager();
        String line = "";
        String content = "";
        URL ur = new URL("https://thanhnien.vn/");

        HttpsURLConnection urlc = (HttpsURLConnection) ur.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

        while ((line = br.readLine()) != null) {
            content += line;
        }
        ex2.inputStack(content);
    }
}
