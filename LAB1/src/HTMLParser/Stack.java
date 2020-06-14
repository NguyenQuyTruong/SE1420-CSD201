/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLParser;

/**
 *
 * @author minhv
 */
public class Stack {

    public static final int SIZEARRAY = 1000; //define size of array
    private String[] html; //create array used for storage
    private int top = -1;

    /**
     * Constructor default
     */
    public Stack() {
	html = new String[SIZEARRAY];
    }

    /**
     * Get size of stack
     * @return size of stack 
     */
    public int size() {
	int size = top;
	//because top start from -1 so need to +1 to become true length
	return (size + 1);
    }

    /**
     * Check is empty or not
     * @return true or false
     */
    public boolean isEmpty() {
	return size() < 0;
    }

    /**
     * Push an element into stack
     * @param tag 
     */
    public void push(String tag) {
	if (top == html.length) {
	    System.out.println("Out of stack");
	} else {
	    top++; //increase top for add
	    html[top] = tag; //add stack
	}
    }
    
    /**
     * Take first element in stack
     * @return an element
     */
    public String pop() {
	String tag;
	//make sure tag is not empty for take
	if (isEmpty()) {
	    return null;
	}
	//get tag
	tag = html[top];
	//set top to null 
	//set address of top to null for Garbage Collection remove it
	html[top] = null;
	//decrease size
	if (top > -1) {
	    top--;
	}
	return tag;
    }

    /**
     * Get top of stack without remove it
     * @return top of stack
     */
    public String top() {
	if (isEmpty()) {
	    return null;
	}
	return html[top];
    }

}
