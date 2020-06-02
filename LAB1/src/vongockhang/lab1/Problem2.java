package vongockhang.lab1;

import java.io.IOException;

import vongockhang.lab1.Stack.StackException;

public class Problem2 {
	Stack stack = new Stack(500); //init stack
	CSV csv = new CSV();

	
	
	/**
	 *  to compare 2 tags current close tag and top of stack tag
	 *  
	 * @param tag
	 * @param stackTag
	 * @return true if tag suitable with close tag
	 */
	private boolean compareTag(String tag, String stackTag) {
		return false;
	}
	
	/**
	 * this method will simplify tags and put/get from stack to process it
	 * some special tag will be skip (also count it)
	 * @param tag current tag which need to process
	 * @throws StackException 
	 */
	private void ProcessTag(String tag) throws StackException {
		tag = tag.toLowerCase(); //make sure, test case can't trick us!
		
		switch(tag) {
		case "<!doctype html>": 
			
		default:
			break;
		}
		
		if (tag.contentEquals("<!doctype html>")) {
			csv.UpdateValue("<!doctype html>"); 
			//this doctype tag is one of special, so we count it as a tag for easy process	
		}else if (tag.contains("<meta")) {
			csv.UpdateValue("<meta>");
			//meta tag is another special!
		}else { 
			//fun part which needs stack for process
			
			if (tag.contains("</")) { //this is not a closing tag, put it to stack
				stack.Push(tag);
			}else { //This is Closting Tag condition, lets check it with the top of our Stack
				
			}
			
			System.out.println(tag);
		}
	}
	private void ParsingHTML(String body) throws StackException {
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
				
				ProcessTag(tag);
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
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
