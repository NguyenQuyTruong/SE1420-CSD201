/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.Arrays;


/**
 *
 * @author KHAM
 */

public class MyStack {
    public static final int CAPACITY = 10000;
    int top = -1;
    String[] ar = new String[CAPACITY];
    public boolean isEmpty(){
        return top == -1;
    }
    
    public String pop(){
        if(isEmpty()) return null;
        String data = ar[top];
        ar[top] = null;
        top--;
        return data;
    }
    
    public void push(String data) {
        top++;
        ar[top] = data;
    }
    
    public void print(){
        for(int i = 0 ; i <= top; i++){
            System.out.print(ar[i] + " ");
        }
    }
    
    public String getTop(){
        if(isEmpty()) throw new IllegalStateException();
        return ar[top];
    }
    
}
