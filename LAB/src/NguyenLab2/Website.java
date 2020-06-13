/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NguyenLab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ADMIN
 */
public class Website {
    /**
	 * Download HTML body given URL
	 * @param siteUrl
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
    public static String DownloadWebsiteBody(String siteUrl) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(siteUrl).openConnection();
		//open new connection to site url
		int respCode = connection.getResponseCode();
		//get response code 
		if (respCode == 200) { //200 - OK
			InputStream inputStream = connection.getInputStream(); //get input stream from connection 
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			//Buffer from Input stream
			StringBuilder body = new StringBuilder(); //HTML body
			String currentLine; //current line in HTML
			while((currentLine = reader.readLine()) != null) {
				body.append(currentLine);
                                }
                                reader.close(); //remember to close it!
			return body.toString();
		
		
			}
                 return null;
                 
}
}
