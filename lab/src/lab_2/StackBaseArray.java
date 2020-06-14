/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_2;

/**
 *
 * @author Khả Thi
 */
public class StackBaseArray implements Stack{
    int Check =-1;
    String Array[];
    public StackBaseArray(String n){
        
        Check = -1;
    }
    @Override
    public void Push(String tag){
        if(Check ==Array.length){
            System.out.println("Stack is full!");
        }
        Check++;
        Array[Check] = tag;
    }
    @Override
    public String Pop(){
        if(Check == -1){
            System.out.println("Stack is empty!");
            return null;
        }
        Array[Check] = null;
        return Array[Check--];
    }

    @Override
    public String GetTop() {
        if(Check == -1){
            System.out.println("Stack is empty!");
            return null;
        }
        return Array[Check];
    }

    @Override
    public boolean IsEmpty() {
        if(Check == -1){
            return true;
        }

        return false;
    }

    @Override
    public int Size() {
        return Check;
    }

    @Override
    public void Print() {
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }
}