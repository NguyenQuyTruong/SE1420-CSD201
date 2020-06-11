/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class singlyLinkedList {

    private class Node {

        String name;
        int score;
        Node next;

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(String val1, int val2, Node n) {

            name = val1;
            score = val2;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(String val1, int val2) {

            this(val1, val2, null);
        }
    }

    private Node head;
    private Node tail;

    /**
     * Constructor.
     */
    public singlyLinkedList() {


        head = null;
        tail = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {

        return head == null;
    }

    /**
     * The size method returns the length of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {

        int count = 0;
        Node p = head;

        while (p != null) {

            count++;
            p = p.next;
        }

        return count;
    }

    public void insert(String name, int score) {

        Node node = new Node(name, score);

        if (isEmpty()) {

            head = node;
            tail = node;
        } else if (head.score <= node.score) {

            node.next = head;
            head = node;
        } else {

            Node frontPtr = head.next;
            Node backPtr = head;

            while (frontPtr.score > node.score && frontPtr.next != null) {

                backPtr = backPtr.next;
                frontPtr = frontPtr.next;
            }

            if (frontPtr == null || frontPtr.score > node.score) {
                
                frontPtr.next = node;
                tail = node;
            } else {
                
                backPtr.next = node;
                node.next = frontPtr;
            }
        }
        if (size() > 10) {

            Node currentPtr = head;

            while (currentPtr.next != tail) {

                currentPtr = currentPtr.next;
            }

            tail = currentPtr;
            currentPtr.next = null;
        }
    }

    public void printList() {

        Node temp = head;

        while (temp != null) {

            System.out.print(temp.name + " " + temp.score + " ");
            System.out.println("");
            temp = temp.next;
        }
    }

}
