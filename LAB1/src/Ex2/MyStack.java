/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author KHAM
 */
public class MyStack {

//    static int CAPACITY = 1000;
//    char[] ar = new char[CAPACITY];
    ArrayList ar = new ArrayList();
    int top = -1;
//    public boolean isEmpty() {
//    }
//
//    public int pop() {
//        
//        top--;
//    }
    public boolean isEmpty(){
        return top == -1;
    }
    
    public void pop(){
        if(isEmpty()){
            
        }
    }
    
    public void push(String data) {
        top ++;
        ar.add(data);
    }
    public void print(){
        System.out.println(ar);
    }
}
