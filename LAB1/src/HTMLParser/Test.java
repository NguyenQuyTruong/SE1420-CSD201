/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

import java.util.Scanner;

/**
 *
 * @author minhv
 */
public class Test {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	HTMLValidateAndCount html = new HTMLValidateAndCount();
	String tag = sc.nextLine();
	System.out.println(html.checkTag(tag));
	System.out.println(html.converToCloseTag(tag));
    }
}
