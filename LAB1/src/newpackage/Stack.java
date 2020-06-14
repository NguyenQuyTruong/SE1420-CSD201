/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author liemn
 */
public class Stack {
    int top = 0;
    String [] stackTag;
    public final int sz = 1000;
    public Stack(int sz){
        stackTag = new String[sz];
    }
    public int size(){
        return top;
    }
    public boolean  isEmpty(){
        if(top==-1){
            return true;
        }
        return false;
    }
    public void push(String htmlTag){
        if(size()==stackTag.length){
            System.out.println("Stack Full");
        }else{
            stackTag[++top] = htmlTag;
        }
    }
    public String top(){
        if(isEmpty()){
            return null;
        }
        return stackTag[top];
    }
    public String pop(){
        if(isEmpty()){
            return null;
        }
        String htmlTag = stackTag[top];
        stackTag[top] = null;
        top --;
        return htmlTag;
    }   
}
