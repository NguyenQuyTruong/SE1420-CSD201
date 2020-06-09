/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.io.Serializable;

/**
 *
 * @author Khanh Hoa
 */
public class Node<E> implements Serializable {

    private static final long serialVersionUID = 1L;
    public E element; // reference to the element stored at this node
    public Node<E> prev; // reference to the previous node in the list
    public Node<E> next; // reference to the subsequent node in the list

    public Node(E e, Node<E> p, Node<E> n) {
        element = e;
        prev = p;
        next = n;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> p) {
        prev = p;
    }

    public void setNext(Node<E> n) {
        next = n;
    }
}
