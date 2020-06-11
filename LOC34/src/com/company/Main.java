package com.company;

public class Main {

    public static void main(String[] args) {
        BSTree t = new BSTree();
        t.insert(7);
        t.insert(6);
        t.insert(12);
        t.insert(2);
        t.insert(10);
        t.insert(11);
        t.insert(13);
        t.insert(9);
        t.insert(14);
        t.delete(12);
        t.print();
	// write your code here
    }
}
