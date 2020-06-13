/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author nds72
 */
public class Stack {

    public static final int CAPACITY = 1000;//default array capacity
    private String[] data; // generic array used for storage
    private int t = -1;// index of the top element in stack

    public Stack(int CAPACITY) {
        data = new String[CAPACITY];
    }

    public int size() {
        return t + 1;
    }

    public boolean isEmty() {
        return t == -1;
    }

    public void push(String e) {
        if (size() == data.length) {
            throw new IllegalStateException("Stack is full");
        }
        data[++t] = e;// increment t before storing new item
    }

    public String top() {
        if (isEmty()) {
            return null;
        }
        return data[t];
    }

    public String pop() {
        if (isEmty()) {
            return null;
        }
        String answer = data[t];
        data[t] = null;// dereference to help garbage collection
        t--;
        return answer;
    }
}
