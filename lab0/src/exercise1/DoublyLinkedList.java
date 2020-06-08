/*
 * This code is reference from the book Data Structures and Algorithms in Java.
 */
package exercise1;

/**
 *
 * @author Khanh Hoa
 */
public class DoublyLinkedList<E> {

    private static final long serialVersionUID = 1L;
    // instance variables of the DoublyLinkedList
    public Node<E> header; // header sentinel
    public Node<E> trailer; // trailer sentinel
    public int size = 0; // number of elements in the list

    /**
     * Constructs a new empty list.
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }

    /**
     * Returns the number of elements in the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the first element of the list.
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement(); // first element is beyond header
    }

    /**
     * Returns (but does not remove) the last element of the list.
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement(); // last element is before trailer
    }

    /**
     * Adds element e to the front of the list.
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext()); // place just after the header
    }

    /**
     * Adds element e to the end of the list.
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer); // place just before the trailer
    }

    /**
     * Removes and returns the first element of the list.
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null; // nothing to remove
        }
        return remove(header.getNext()); // first element is beyond header
    }

    /**
     * Removes and returns the first element of the list.
     */
    public E removeLast() {
        if (isEmpty()) {
            return null; // nothing to remove
        }
        return remove(trailer.getPrev()); // last element is before trailer
    }

    /**
     * Adds element e to the linked list in between the given nodes.
     */
    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     */
    public E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
} //----------- end of DoublyLinkedList------------------

