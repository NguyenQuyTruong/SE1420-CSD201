/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1;

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

    public int size() {
	int size = top;
	return (size + 1);
    }

    public boolean isEmpty() {
	return size() < 0;
    }

    public void push(String tag) {
	if (top == html.length) {
	    System.out.println("Out of stack");
	} else {
	    top++; //increase top for add
	    html[top] = tag; //add stack
	}
    }

    public String pop() {
	String tag;
	if (isEmpty()) {
	    return null;
	}
	tag = html[top];
	html[top] = null;
	if (top > -1) {
	    top--;
	}
	return tag;
    }

    public String top() {
	if (isEmpty()) {
	    return null;
	}
	return html[top];
    }

}
