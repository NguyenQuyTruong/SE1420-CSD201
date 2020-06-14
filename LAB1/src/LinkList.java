
import java.io.FileWriter;
import java.io.IOException;

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
            return data;                //contructor get all data 
        }

        public void setData(manageGamer data) {
            this.data = data;           // contructor sett data 
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
        if (isEmpty()) {            //If list empty return null, if not funtion can be error
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
        Node nextNode = userNode.getNext();
        Node prevNode = userNode.getPrev();
        nextNode.setPrev(prevNode);
        prevNode.setNext(nextNode);
        sizeList--;
        return userNode.getData();
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

    public manageGamer removeNode(String email) {
        Node delNode = searchDelete(email);
        if (delNode != null) {
            return remove(delNode);
        }
        return null;
    }

    public manageGamer searchUserByEmail(String email) {
        for (Node n = header.next; n != trailer; n = n.next) {
            if (n.getData().getUserEmail().contentEquals(email)) {
                return n.getData();
            }
        }
        return null;
    }

    public Node searchDelete(String email) {
        for (Node n = trailer.next; n != trailer; n = n.next) {
            if (n.getData().getUserEmail().contentEquals(email)) {
            }
        }
        return null;
    }

    public manageGamer getfirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getData();
    }

    public void addFirst(Node node) {
        //call function add
        header.next.prev = node;
        node.next = header.next;
        node.prev = header;
        header.next = node;
        //return to header

    }

    public void addLast(Node node) {
        //call function add, return trailer
        trailer.prev.next = node;
        node.prev = trailer.prev;
        node.next = trailer;
        trailer.prev = node;

    }

    public void addBetween(manageGamer data) {
        Node newbie = new Node(data, trailer, header);
        int point = data.getPoint();
        if (isEmpty()) {
            header.next = newbie;
            newbie.prev = header;
            newbie.next = trailer;
            trailer.prev = newbie;
        } else {
            int pointOfHeader = header.next.getData().getPoint();
            int pointOfTrailer = trailer.prev.getData().getPoint();

            if (point < pointOfTrailer) {
                addLast(newbie);
            } else if (point > pointOfHeader) {
                addFirst(newbie);
            } else {
                Node currentNode = header.next;
                while (currentNode.getData().getPoint() > newbie.getData().getPoint()) {
                    currentNode = currentNode.next;
                }
                currentNode.prev.next = newbie;
                newbie.next = currentNode;
                newbie.prev = currentNode.prev;
                currentNode.prev = newbie;
            }
        }
        sizeList++;                                 //increase size of list
    }

    public void printList() {
        Node currentNode = header.getNext();
        while (currentNode != trailer) {
            System.out.println(currentNode.getData() + "\n");
            currentNode = currentNode.getNext();
        }
    }
    public void writeToCSVfile(String fileName) throws IOException {
	FileWriter fr = null;
	try {
	    fr = new FileWriter(fileName);
	    fr.append("email, eoint\n");
	    for (Node n = header.next; n != trailer; n = n.next) {
		String data = String.format("%s, %d\n", n.getData().getUserEmail(),n.getData().getPoint());
		fr.append(data);
	    }
	} catch (IOException e) {
	    System.out.println("Can't write a file!!");
	} finally {
	    try {
		if (fr != null) {
		    fr.close();
		}
	    } catch (IOException e) {
		System.out.println("File not exist!!");
	    }
	}
    }
}
