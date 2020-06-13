/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class LinkList {

    private class Node {

        manageGamer data;    //data gamer
        Node next;          // next node
        Node prev;         // prev node

        /**
         * Constructor Node
         *
         * @param data
         * @param next
         * @param prev
         */
        public Node(manageGamer data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        //getter and setter
        public manageGamer getData() {
            return data;
        }

        public void setData(manageGamer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private Node header;            //header of list
    private Node trailer;          //trailer of list
    private int sizeList = 0;     //size of list
    // Contructor def

    public LinkList() {
        header = new Node(null, null, null);
        trailer = new Node(null, null, header);
        header.setNext(trailer);
    }

    //get return size
    public int sizeOfList() {
        return sizeList;
    }

    //if list == 0, return size = 0
    public boolean isEmpty() {
        return sizeList == 0;
    }

    public manageGamer getFisrt() {
        if (isEmpty()) {            //If list empty return null, if not funtion cam be error
            return null;
        }
        return header.getNext().getData();
    }

    public manageGamer getLast() {

        if (isEmpty()) {            //If list empty return null, if not funtion cam be error
            return null;
        }
        return trailer.getPrev().getData();
    }

    private manageGamer remove(Node userNode) {
        Node nextNode = userNode.getNext(); //get next Node of Node inputted
        Node prevNode = userNode.getPrev(); //get prev Node of Node inputted
        nextNode.setPrev(prevNode); //set prev of next Node is prev Node has getted
        prevNode.setNext(nextNode); //set next of prev Node is next Node has getted
        sizeList--;		    //decrease size of list after remoce
        return userNode.getData(); //return data
    }

    public manageGamer removeFirst() {
        if (isEmpty()) {    // if dont remove anyone, return null
            return null;
        }
        return remove(header.getNext());
    }

    public manageGamer removeLast() {
        if (isEmpty()) {    //if dont remove anyone, return null
            return null;
        }
        return remove(trailer.getPrev());
    }

}
