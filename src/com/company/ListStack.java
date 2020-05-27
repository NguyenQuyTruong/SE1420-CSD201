package com.company;

public class ListStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();

    @Override
    public void push(E info) {
        list.addFirst(info);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E top() {
        return list.getTop();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void print() {
        list.print();
    }
}
