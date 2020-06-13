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
            else if(content.charAt(i) == '-' ) {
                tag += "-";
                check = false;
            }
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' ) {
                tag += content.charAt(i);
            }
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) ) {
                tag += ">";
                check = false;
            }
        }
    }
}
