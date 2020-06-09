/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLtags;

/**
 *
 * @author nhoxr
 */
public class Stack {
    public static final int CAPACITY = 1000; //default arrya capacity
    private String[] tag; //data type of tag html
    private int t = -1; //index of the top element in stack

    public Stack(int capacity) {
	tag = new String[capacity];
    }
    
    /**
     * this method use to return size of the stack
     * @return size of stack
     */
    public int size() {
	return (t + 1);
    }
    
    /**
     * this method use to check is the stack empty or not
     * @return true or false
     */
    public boolean isEmpty() {
	return (t == -1);
    }
    
    /**
     * this method use to push data(String htmlTag) to the stack
     * and it will check the stack is full or not
     * @param htmlTag
     */
    public void push(String htmlTag) {
	if (size() == tag.length) {
	    System.out.println("Stack is full");
	} else {
	    tag[++t] = htmlTag; //increment size of stack before storing new item
	}
    }
}
