/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *EX2 but it ís not complete
 * @author SE140279
 */
public class Stack {
    int top;
    int max = 10000;
    String[] array = new String[max];
    public boolean isEmpty() {
        return top == -1;
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String data = array[top];
        array[top] = null;
        top--;
        return data;
    }

    public void push(String data) {
        top++;
        array[top] = data;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
