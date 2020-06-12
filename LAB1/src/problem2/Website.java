package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
		//Add useragent to prevent 403 Response code

		
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
			
			//System.out.println(body);
			reader.close(); //remember to close it!
			
			return body.toString();
		}else {
			throw new IOException("ERROR CODE: " + respCode);
		}
	}
	
}
