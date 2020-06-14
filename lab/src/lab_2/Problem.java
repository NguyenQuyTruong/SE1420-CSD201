/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Khả Thi
 */

public class Problem {
    Csv cv = new Csv();
    StackBaseArray ba = new StackBaseArray(200);
    DownWeb d = new DownWeb();
    /**
	 * Check almost every case of tag can heppen to add to map
	 * @param tag
	 */
 public void processingHTMLTag(String tag) throws Exception {
     
           
     if(tag.equalsIgnoreCase("<nav>"))
            cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<ol>"))
             cv.CheckAndUpdate("<ol>");
        else if(tag.equalsIgnoreCase("<meta>"))
             cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<link>"))
             cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<img>"))
            cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<br>"))
             cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<hr>"))
            cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<input>"))
             cv.CheckAndUpdate(tag);
        else if(tag.equalsIgnoreCase("<![endif]-"))
             cv.CheckAndUpdate("<![endif]-->");
        else if(tag.equalsIgnoreCase("<head>"))
             cv.CheckAndUpdate("<head>");
        else if(tag.equalsIgnoreCase("<body>"))
             cv.CheckAndUpdate("<body>");
        else if(tag.equalsIgnoreCase("<a>"))
             cv.CheckAndUpdate("<a>");
        else if(tag.equalsIgnoreCase("<h1>"))
             cv.CheckAndUpdate("<h1>");
        else if(tag.equalsIgnoreCase("<script>"))
             cv.CheckAndUpdate("<script>");
        else if(tag.equalsIgnoreCase("<picture>"))
             cv.CheckAndUpdate("<picture>");
        else if(tag.equalsIgnoreCase("<li>"))
             cv.CheckAndUpdate("<li>");
        else if(tag.equalsIgnoreCase("<p>"))
             cv.CheckAndUpdate("<p>");
        else if(tag.equalsIgnoreCase("<span"))
             cv.CheckAndUpdate("<span");
        else if(tag.equalsIgnoreCase("<td>"))
             cv.CheckAndUpdate("<td>");
        else if(tag.equalsIgnoreCase("<tr>"))
             cv.CheckAndUpdate("<te>");
        else if(tag.equalsIgnoreCase("<th>"))
             cv.CheckAndUpdate("<th>");
        else if(tag.equalsIgnoreCase("<u>"))
             cv.CheckAndUpdate("<u>");
        else if(tag.equalsIgnoreCase("<ul>"))
             cv.CheckAndUpdate("<ul>");
        
        else{
            if(tag.contains("</") == false) {
                ba.Push(tag);
                cv.CheckAndUpdate(tag);
            }
            else if(ba.GetTop().equalsIgnoreCase(tag.replace("/", "")) == true) {
                ba.Pop();
            }
        }
 }
 /**
	 * Check tag type
	 */
  public void CheckTag(String filename) throws Exception {
        String line;
        String tag="";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while((line = reader.readLine()) != null) {
	String checkTag = line;
        boolean caseTag = false;        
        for(int i = 0; i < checkTag.length(); i++) {           
            if(checkTag.charAt(i) == '<') {
                tag = "<";
                caseTag = true;
            }           
            else if(checkTag.charAt(i) == '-' && caseTag == true) {//comment tag
                tag += "-";
                processingHTMLTag(tag);
                caseTag = false;
            }
            else if(checkTag.charAt(i) != '>' && checkTag.charAt(i) != ' ' && caseTag == true) {
                tag += checkTag.charAt(i);
            }
            else if(((checkTag.charAt(i) == '>') || (checkTag.charAt(i) == ' ')) && caseTag == true) {
                tag += ">";
                caseTag = false;
                processingHTMLTag(tag);
            }
          }
       }
        
    }
  /**
	 * Finnal step: run the program to slove problem
	 * @param urlWeb, filename
	 */
  public Problem(String urlWeb, String filename) {
        try {
           DownWeb.Download(urlWeb);
//           String content =cv.readFile(filename);
            CheckTag(filename);
            ba.Print();
            cv.SaveToFile("OutPut.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }    
}
