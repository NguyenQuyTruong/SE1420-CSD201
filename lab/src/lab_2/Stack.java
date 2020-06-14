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
public interface Stack {
    public void Push(String tag);
    public String Pop();
    public String GetTop();
    public boolean IsEmpty();
    public int Size();
    public void Print();
}
