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

    private void analyzeHTMLTag(String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
