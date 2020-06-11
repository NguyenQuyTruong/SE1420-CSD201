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
    int count = 0;
    final String opening = "<";
    final String closing = ">";

    final String Mark = "!";
    final String Mark2 = "/";
    final String Mark3 = ".";

    public void inputStack(String content) {
        StringBuilder sb = new StringBuilder();
        char c[] = content.toCharArray();
        int j = 0;
        int k = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (opening.indexOf(c[i]) != -1 && Mark.indexOf(c[i + 1]) == -1 && Mark2.indexOf(c[i + 1]) == -1) {
                sb.insert(k, c[i]);
                k++;
                for (j = 1; j < c.length - i; j++) {
                    if (c[i + j] < 'A' || (c[i + j] > 'Z' && c[i + j] < 'a') || c[i + j] > 'z') {
                        break;
                    } else {
                        sb.insert(k, c[i + j]);
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
