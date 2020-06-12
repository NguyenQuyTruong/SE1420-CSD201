/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author minhv
 */
public class Test {

    public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	HTMLValidateAndCount html = new HTMLValidateAndCount();
//	String tag = sc.nextLine();
//	System.out.println(html.checkTag(tag));
//	System.out.println(html.converToCloseTag(tag));
//	System.out.println(FileReadWrite.readData("index.html"));
//	System.out.println(FileReadWrite.readData("index.html").length());
//	String s = "Hello ";
//	System.out.println(s.length());
//	System.out.println(HTMLValidateAndCount.regexCheckTag(">"));
//	Character c = 'T';
//	System.out.println(Character.toString(c));
//	System.out.println(String.valueOf(c));
	HTMLValidateAndCount html = new HTMLValidateAndCount();
	ArrayList<String> htmlList;
	htmlList = html.seperateTag("<head> <title>My First Page</title>    </head>    <body>");
	for (String htmlTag : htmlList) {
	    System.out.println(htmlTag);
	}
    }
}
