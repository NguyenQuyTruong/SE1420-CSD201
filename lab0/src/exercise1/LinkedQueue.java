/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author PC
 * @param <E>
 */
public class LinkedQueue<E> implements IPriorityQueue<E> {

    private DoublyLinkedList<E> list = new DoublyLinkedList<>(); // an empty list

    public LinkedQueue() {
    } 

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E element) {
        list.addLast(element);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }
}
