package vongockhang.lab1;

import java.io.IOException;

import vongockhang.lab1.Stack.StackException;

public class Problem2 {
	Stack stack = new Stack(200); //init stack
	CSV csv = new CSV();

	/**
	 * Some tag will have format like this <a href="..." > the goal is normalize it to => <a>
	 * @param Tag
	 * @return normalized tag
	 */
	private String NormalizeTag(String tag) {
		String[] tagSplited = tag.split(" "); //split the tag based on space
		if (tagSplited.length == 1) { //There is no space at all, so the tag is valid LIKE : <a> 
			return tag;
		}else { //there are another HTML attributes in tag, but we only need the tag name 
			// LIKE: <a href="..."> ==> <a>
			
			
			String normalizedTag = tagSplited[0] + '>';
			
			System.out.println("\nNormalized: " + tag + " : " + normalizedTag);
			return normalizedTag; //<a + > ==> <a>
		}
	}
	
	/**
	 *  to compare 2 tags current close tag and top of stack tag
	 *  
	 * @param tag
	 * @param stackTag
	 * @return true if tag suitable with close tag
	 */
	private boolean compareTag(String tag, String stackTag) {
		tag = tag.replace("/","");
		return tag.contentEquals(stackTag);
	}
	
	private boolean StandaloneTag(String tag, String body) {
		tag = tag.replace("<", "</");
		
		return !body.contains(tag);
	}
	
	/**
	 * this method will simplify tags and put/get from stack to process it
	 * some special tag will be skip (also count it)
	 * @param tag current tag which need to process
	 * @param body 
	 * @throws StackException 
	 */
	private void ProcessTag(String tag, String body) throws StackException {
		tag = tag.toLowerCase(); //make sure, test case can't trick us!
		
		switch(tag) {
		case "<!doctype html>": 
			
		default:
			break;
		}
		
		if (!tag.contains("</") && StandaloneTag(tag, body)) { //not close tag and that is a standalone tag!! F*** This tag	
			csv.UpdateValue(tag);
		}else {
			//fun part which needs stack for process
			tag = NormalizeTag(tag); //normalizing tag
			
			if (!tag.contains("</")) { //this is not a closing tag, put it to stack
				stack.Push(tag);
			}else if (compareTag(tag, stack.GetTop())){ //This is closing Tag condition, lets check it with the top of our Stack
				//System.out.println("Stack pop! " + stack.GetTop()); //Debug line, comment it if you don't want to
				csv.UpdateValue(stack.GetTop()); //remember, using open tag to increase count, not closing
												// ==> using stack tag, not the closing one
				stack.Pop(); 
			}else { //when tag is standalone, this can be happen
				System.out.println("Special case:  " + tag + " : " + stack.GetTop());
				
			}
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
				
			}else if ((body.charAt(i) != '>' && body.charAt(i) != ' ') && (suckingCharacterToTag)){
				tag += body.charAt(i); //normal character, add it to our incomplete tag
				
			}else if ((body.charAt(i) == '>' || body.charAt(i) == ' ') && (suckingCharacterToTag)) {
				tag += '>'; //close tag => end of tag
				suckingCharacterToTag = false;  
				//Turn this flag off, we already have enough characters to create a tag
				
				ProcessTag(tag, body);
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
			csv.WriteCSV(csvPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
