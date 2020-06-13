/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;

/**
 *
 * @author KHAM
 */
public class Ex2Manager {

    MyStack ms = new MyStack();
    ArrayList<Tag> ar = new ArrayList<>();
/**
 * 
 * @param content : whole source code of the link 
 */
    public void inputStack(String content) {
        char c[] = content.toCharArray();
        String openTag = "";
        String closeTag = "";
        int tmp = 0;
        int k = 0;
        int exist = 0;
        for (int i = 0; i < c.length; i++) {
            openTag = "";
            exist = 0;
            if (c[i] == '<' && c[i + 1] != '/') {
                if ((c[i + 1] >= 'A' && c[i + 1] <= 'Z') || (c[i + 1] >= 'a' && c[i + 1] <= 'z')) {
                    openTag += '<';
//                    openTag += '/';
                    for (int j = 1; j < c.length - i; j++) {
                        if ((c[i + j] >= 'A' && c[i + j] <= 'Z') || (c[i + j] >= 'a' && c[i + j] <= 'z')) {
                            openTag += c[i + j];
                        } else {
                            break;
                        }
                    }
                    openTag += '>';
                    ms.push(openTag);

                    for (Tag ar1 : ar) {
                        if (ar1.getTagName().equals(openTag)) {
                            ar1.setQuantity(ar1.getQuantity() + 1);
                            exist = 1;
                            break;
                        }
                    }
                    if (exist == 0) {
                        Tag t = new Tag(openTag, 1);
                        ar.add(t);
                    }
                }
            }
            if (c[i] == '<' && c[i + 1] == '/') {
                tmp = 0;
                closeTag = "</";
                for (k = 2; k < c.length - i; k++) {
                    if ((c[i + k] >= 'A' && c[i + k] <= 'Z') || (c[i + k] >= 'a' && c[i + k] <= 'z')) {
                        closeTag += c[i + k];
                    } else {
                        break;
                    }
                }
                closeTag += '>';
                closeTag = closeTag.replace("</", "<");
                while (tmp != 1) {
                    if (closeTag.equals(ms.getTop())) {
                        ms.pop();
                        tmp = 1;
                    } else {
                        for (int l = 0; l < ar.size(); l++) {
                            if (ar.get(l).getTagName().equals(ms.getTop())) {
                                ar.remove(l);
                                break;
                            }
                        }
                        ms.pop();
                    }
                }
            }
        }
    }
}
