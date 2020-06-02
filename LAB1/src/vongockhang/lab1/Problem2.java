package vongockhang.lab1;

import java.io.IOException;

public class Problem2 {
	Stack stack = new Stack(500); //init stack
	
	private void ParsingHTML(String body) {
		System.out.println(body);
		System.out.println("===================");
		String tag = "";
		
		boolean suckingCharacterToTag = false;
		for(int i = 0; i < body.length(); i++) { //looping though any single character
			if(body.charAt(i) == '<') { 
				//if open bracket then find close braket compile it => a TAG
				tag = "<";
				suckingCharacterToTag = true; 
				//lol, this flag will let us know we're collecting characters into a TAG 
				
			}else if ((body.charAt(i) != '>') && (suckingCharacterToTag)){
				tag += body.charAt(i); //normal character, add it to our incomplete tag
				
			}else if ((body.charAt(i) == '>') && (suckingCharacterToTag)) {
				tag += '>'; //close tag => end of tag
				suckingCharacterToTag = false;  
				//Turn this flag off, we already have enough characters to create a tag
				
				System.out.println(tag);
			}
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
