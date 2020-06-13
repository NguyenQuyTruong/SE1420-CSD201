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
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author KHAM
 */
public class Ex2Manager {

    MyStack ms = new MyStack();
    HashMap hm = new HashMap();
    int count = 0;
//    final char opening = '<';
//    final char closing = '>';
//    final String space = " ";
//    final String Mark = "/";
//    final String Mark2 = "!";
    
    public void inputStack(String content) {
        char c[] = content.toCharArray();
        String openTag = "";
        String closeTag = "";
        for (int i = 0; i < c.length; i++) {
            openTag = "";
            if (c[i] == '<' && c[i + 1] != '/') {
                if ((c[i + 1] >= 'A' && c[i + 1] <= 'Z') || (c[i + 1] >= 'a' && c[i + 1] <= 'z')) {
                    openTag += c[i];
                    for (int j = 1; j < c.length - i; j++) {
                        if ((c[i + j] >= 'A' && c[i + j] <= 'Z') || (c[i + j] >= 'a' && c[i + j] <= 'z')) {
                            openTag += c[i + j];
                        }
                    }
                    openTag += '>';
                    ms.push(openTag);
                }
            }
            if (c[i] == '<' && c[i + 1] == '/') {
                closeTag = "</";
                for (int k = 2; k < c.length - i; k++) {
                    if ((c[i + k] >= 'A' && c[i + k] <= 'Z') || (c[i + k] >= 'a' && c[i + k] <= 'z')) {
                        closeTag += c[i + k];
                    }
                }
                closeTag += '>';
                closeTag = closeTag.replace("</", "<");
                while (!closeTag.equals(ms.pop())) {
                    if (closeTag.equals(ms.pop())) {
                        break;
                    } else {
                        ms.pop();
                    }
                }
            }
        }
        ms.print();
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
