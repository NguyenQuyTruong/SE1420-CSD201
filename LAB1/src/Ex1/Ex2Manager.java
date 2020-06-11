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
    final String opening = "<";
    final String closing = ">";
    final String space = " ";
    public void inputStack(String content) {
        StringBuilder sb = new StringBuilder();
        char c[] = content.toCharArray();
        int j = 0;
        int k = 0;
        int tmp = 0;
        for (int i = 0; i < c.length - 1; i++) {
            tmp = 0;
            if (opening.indexOf(c[i]) != -1) {
                sb.insert(k, c[i]);
                k++;
                tmp++;
                for (j = 1; j < (c.length - i); j++) {
                    if ((c[i + j] >= 'A' && (c[i + j] <= 'Z') || (c[i + j] >= 'a') && c[i + j] <= 'z')) {
                        sb.insert(k, c[i + j]);
                        k++;
                        tmp++;
                    } else if(space.indexOf(c[i + j])!= -1){
                        for(int v = 1; v < (c.length - i - j); v++){
                            if(closing.indexOf(c[i + j + v]) != -1){
                                sb.insert(k, c[i + j + v]);
                                k++;
                                break;
                            }
                            if(opening.indexOf(c[i + j + v]) != -1){
                                sb.delete(i, i+j);
                                break;
                            }
                        }
                    }
                    else {
                        sb.insert(k,closing);
                        k++;
                        
                    }
                }
                sb.insert(k, closing);
                k += 1;
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        // Test 
        Ex2Manager ex2 = new Ex2Manager();
        String line = "";
        String content = "";
        URL ur = new URL("https://vnexpress.net/");

        HttpsURLConnection urlc = (HttpsURLConnection) ur.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

        while ((line = br.readLine()) != null) {
            content += line;
        }
        ex2.inputStack(content);
    }
}
