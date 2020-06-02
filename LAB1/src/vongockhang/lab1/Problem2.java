package vongockhang.lab1;

import java.io.IOException;

public class Problem2 {
	Stack stack = new Stack(500); //init stack
	
	private void ParsingHTML(String body) {
		System.out.println(body);
		
		for(int i = 0; i < body.length(); i++) { //looping though any single character
			
		}
	}
	/**
	 * Running solve problem 2
	 * @param webUrl
	 * @param csvPath
	 */
	public Problem2(String webUrl, String csvPath) {
		
		try {
			String body = Website.DownloadWebsiteBody(webUrl);
			
			ParsingHTML(body);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
