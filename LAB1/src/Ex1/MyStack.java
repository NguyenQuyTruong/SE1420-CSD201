/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;


/**
 *
 * @author KHAM
 */

public class MyStack {
    public static final int CAPACITY = 10000;
    int top = -1;
    String[] ar = new String[CAPACITY];
    /**
     * 
     * @return top == -1
     */
    public boolean isEmpty(){
        return top == -1;
    }
    
    /**
     * 
     * @return data of array at top and remove top
     */
    public String pop(){
        if(isEmpty()) return null;
        String data = ar[top];
        ar[top] = null;
        top--;
        return data;
    }
    /**
     * 
     * @param data 
     */
    public void push(String data) {
        top++;
        ar[top] = data;
    }
    /**
     * print all stack data
     */
    public void print(){
        for(int i = 0 ; i <= top; i++){
            System.out.print(ar[i] + " ");
        }
    }
    /**
     * 
     * @return data of array of top without removing top 
     */
    public String getTop(){
        if(isEmpty()) throw new IllegalStateException();
        return ar[top];
    }
    
}
