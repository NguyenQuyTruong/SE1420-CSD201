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

    public Node searchUserByEmail(String email) {
        if (isEmpty()) {
            System.out.println("Please add a new user for use, list is empty");
        } else {
            //get node after header
            Node nodeNext = header.getNext();
            
            do {
                if (nodeNext.getData().getUserEmail().equalsIgnoreCase(email)) {
                    return nodeNext;
                } else {                                //countinue to search
                    nodeNext = nodeNext.getNext();
                }
            } while (nodeNext != trailer);
        }
        return null;                                    //no user founded
    }

    public void deleteUserNode(String email) {
        if (isEmpty()) {
            System.out.println("Please add a new user for use, list is empty");
        } else {
            Node userNode = searchUserByEmail(email);
            if (userNode == null) {			//not founded
                System.out.println("User doesn't exit");
            } else {					//founded
                remove(userNode);			//remove
            }
        }
    }

    private void addFL(manageGamer data, Node nextNode, Node prevNode) {
        //create new node
        Node newNode = new Node(data, nextNode, prevNode);
        nextNode.setPrev(newNode);  //set prev of next  
        prevNode.setNext(newNode);  //set next of prev  
        sizeList++;		    //increase size of list
    }

    public void addFirst(manageGamer data) {
        //call function add
        //return to header
        addFL(data, header.getNext(), header);
    }

    public void addLast(manageGamer data) {
        addFL(data, trailer, trailer.getPrev());            //call function add, return trailer
    }

    public void addBetween(manageGamer data, Node nodeNext) {
        if (nodeNext == null) {                         //founded is lowest score so use addLast
            addLast(data);
        } else {
            Node prevNode = nodeNext.getPrev();         //get previous Node
            Node newNode = new Node(data, nodeNext, prevNode); //create new Node
            nodeNext.setPrev(newNode);                  //set newnode( prev of next )
            prevNode.setNext(newNode);                  //set newnode ( next of prev )
            sizeList++;                                 //increase size of list
        }
    }

    public Node searchNode(int point) {
        Node nextnode = header.getNext(); //get node after header
        do {
            //find the user have low point
            if (point > nextnode.getData().getPoint()) {
                return nextnode.next;
            } else {
                // else find a highest point
                nextnode = nextnode.getNext();
            }
        } while (nextnode != trailer);
        return null;
    }

    public void add(manageGamer data) {
        int point = data.getPoint();    //get point from data
        if (isEmpty()) {
            addFirst(data);
        } else {
            if (point > header.getNext().getData().getPoint()) {
                addFirst(data);
            } else if (point < trailer.getPrev().getData().getPoint()) {
                addLast(data);
            } else {
                Node found = searchNode(point);
                addBetween(data, found);
            }
        }
    }

    public void displayPointUserEmail(String email) {
        if (isEmpty()) {
            System.out.println("Please add a new user for use, list is empty");
        } else {
            Node founed = searchUserByEmail(email);
            //user not founded
            if (founed==null) {
                System.out.println("Don't found user yet");
            }
        }
    }
}
