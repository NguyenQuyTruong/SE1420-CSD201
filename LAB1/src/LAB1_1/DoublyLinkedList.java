/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_1;

/**
 *
 * @author minhv
 */
public class DoublyLinkedList {

    /**
     * Create an node of doubly lined list use private to hide information -
     * encapsulation
     *
     * @param <User>
     */
    private class Node {

	User data;	    //data user
	Node next;    //reference to next node
	Node prev;    //reference to prev node

	/**
	 * Constructor for Node
	 *
	 * @param data
	 * @param next
	 * @param prev
	 */
	public Node(User data, Node next, Node prev) {
	    this.data = data;
	    this.next = next;
	    this.prev = prev;
	}

	//getter and setter
	public User getData() {
	    return data;
	}

	public void setData(User data) {
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

    private Node header; //header of doubly lined list
    private Node trailer; //trailer of doubly lined list
    private int sizeList = 0; //size of list

    /**
     * Constructor default
     */
    public DoublyLinkedList() {
	header = new Node(null, null, null);
	trailer = new Node(null, null, header); //trailer is behind header
	header.setNext(trailer);		//set next of header is trailer
    }

    /**
     * Get size of list
     *
     * @return number of size
     */
    public int sizeOfList() {
	return sizeList;
    }

    /**
     * Check list is empty or not
     *
     * @return true or false
     */
    public boolean isEmpty() {
	return sizeList == 0;
    }

    /**
     * Return data of user at the top of list
     *
     * @return User
     */
    public User getFisrt() {
	//catch exception the list is empty and function make error
	if (isEmpty()) {
	    return null;
	}
	return header.getNext().getData();
    }

    /**
     * Return data of user at the last of list Repair for get the highest score
     *
     * @return User
     */
    public User getLast() {
	//catch exception the list is empty and function make error
	if (isEmpty()) {
	    return null;
	}
	return trailer.getNext().getData();
    }

    /**
     * Remove an node from list. Don't need to know the position of node Just
     * need to receive this Node
     *
     * @param userNode
     * @return data user of node have been removed
     */
    private User remove(Node userNode) {
	Node nextNode = userNode.getNext(); //get next Node of Node inputted
	Node prevNode = userNode.getPrev(); //get prev Node of Node inputted
	nextNode.setPrev(prevNode); //set prev of next Node is prev Node has getted
	prevNode.setNext(nextNode); //set next of prev Node is next Node has getted
	sizeList--;		    //decrease size of list after remoce
	return userNode.getData(); //return data
    }

    /**
     * Remove first user of list
     *
     * @return data user of node have been removed
     */
    public User removeFirst() {
	if (isEmpty()) {    //no user to remove
	    return null;
	}
	return remove(header.getNext());
    }

    /**
     * Remove last user of list
     *
     * @return data user of node have been removed
     */
    public User removeLast() {
	if (isEmpty()) {    //no user to remove
	    return null;
	}
	return remove(trailer.getPrev());
    }

    /**
     * Add new node
     *
     * @param data
     * @param nextNode
     * @param prevNode
     */
    private void addForFirstLast(User data, Node nextNode, Node prevNode) {
	//create new node
	Node newNode = new Node(data, nextNode, prevNode);
	nextNode.setPrev(newNode);  //set prev of next node is new node
	prevNode.setNext(newNode);  //set next of prev node is new node
	sizeList++;		    //increase size of list
    }

    /**
     * Add node at the top of list
     *
     * @param data
     */
    public void addFirst(User data) {
	addForFirstLast(data, header.getNext(), header);
    }

    /**
     * Add node at the last of list
     *
     * @param data
     */
    public void addLast(User data) {
	addForFirstLast(data, trailer, trailer.getPrev());
    }

    /**
     * Add node between 2 node Use for add an element in priority queue
     *
     * @param data
     * @param nodeNext
     */
    public void addBetweenNode(User data, Node nodeNext) {
	Node prevNode = nodeNext.getPrev();

	Node newNode = new Node(data, nodeNext, prevNode);
	nodeNext.setPrev(newNode);
	prevNode.setNext(newNode);
	sizeList++;
    }

    /**
     * Function print for testing
     *
     * @param list
     */
    public void printlist(DoublyLinkedList list) {
	Node node = header.getNext();
	System.out.println("Doubly Linked List: ");
	while (node != trailer) {
	    System.out.println(node.getData());
	    node = node.next;
	}
    }

    public Node searchNode(int point) {
	Node nodeNext = header.getNext();

	do {
	    if (nodeNext.getData().getPoint() > point) {
		return nodeNext;
	    } else {
		nodeNext = nodeNext.getNext();
	    }
	} while (nodeNext != null);
	return null;
    }
}
