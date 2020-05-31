package com.company;

public interface Stack<E> {
    public void push(E info);
    public E pop();
    public E top();
    public boolean isEmpty();
    public int size();
    public void print();
}
