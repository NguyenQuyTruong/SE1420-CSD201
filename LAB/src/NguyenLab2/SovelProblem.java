/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenLab2;

/**
 *
 * @author ADMIN
 */
public class SovelProblem {
    Website myWebsite=new Website();
    CSV myCsv=new CSV();
    Stack mystack=new Stack(300);
    public SovelProblem(String urlWeb, String file) {
        try {
            String content = myWebsite.DownloadWebsiteBody(urlWeb);
            analyzeHTMLTag(content);
            myCsv.print();
            myCsv.sorrt(file);            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }

     public void analyzeHTMLTag(String content) throws Exception {
        String tag = "";
        boolean check = false;        
        for(int i = 0; i < content.length(); i++) {           
            // '<' is begin of every tag
            if(content.charAt(i) == '<') {
                tag = "<";
                check = true;
            }           
            // Only comment tag has '-' character => <!--comment-->
            else if(content.charAt(i) == '-' && check == true) {
                tag += "-";
                processingHTMLTag(tag);
                check = false;
            }
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag += content.charAt(i);
            }
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag += ">";
                check = false;
                processingHTMLTag(tag);
            }
        }
    }
  public void processingHTMLTag(String tag) throws Exception {
        if(tag.equalsIgnoreCase("<!DOCTYPE>"))
            myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<!-"))
             myCsv.countTag("<!--comment-->");
        else if(tag.equalsIgnoreCase("<meta>"))
             myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<link>"))
             myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<img>"))
            myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<br>"))
             myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<hr>"))
            myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<input>"))
             myCsv.countTag(tag);
        else if(tag.equalsIgnoreCase("<![endif]-"))
             myCsv.countTag("<![endif]-->");
        else{
            if(tag.contains("</") == false) {
                mystack.push(tag);
                myCsv.countTag(tag);
            }
            else if(mystack.topEl().equalsIgnoreCase(tag.replace("/", "")) == true) {
                mystack.pop();
            }
        }
    }
}
