package vongockhang.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Problem2 {
	Stack stack = new Stack(500); //init stack
	/**
	 * 
	 * @param siteUrl
	 * @return string body HTML
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private String DownloadWebsiteBody(String siteUrl) throws MalformedURLException, IOException {
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
	
	/**
	 * Running solve problem 2
	 * @param webUrl
	 * @param csvPath
	 */
	public Problem2(String webUrl, String csvPath) {
		
		try {
			String body = DownloadWebsiteBody(webUrl);
			System.out.println(body);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
