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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
