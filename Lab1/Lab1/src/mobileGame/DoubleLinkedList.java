/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author nhoxr
 */
public class DoubleLinkedList {

    //create class Node
    public class Node {

	private Gamer gamer;
	private Node right = null;
	private Node left = null;

	//constructor
	public Node(Gamer gamer, Node right, Node left) {
	    this.gamer = gamer;
	    this.right = right;
	    this.left = left;
	}

	public Node(Gamer gamer) {
	    this.gamer = gamer;
	}

	//getter and setter for Node
	public Gamer getGamer() {
	    return gamer;
	}

	public void setGamer(Gamer gamer) {
	    this.gamer = gamer;
	}

	public Node getRight() {
	    return right;
	}

	public void setRight(Node right) {
	    this.right = right;
	}

	public Node getLeft() {
	    return left;
	}

	public void setLeft(Node left) {
	    this.left = left;
	}
    }

    //create 2 main node
    public Node header;
    public Node trailer;
    public int size = 0;

    //create DoubleLinkedList constructor
    public DoubleLinkedList() {
	header = new Node(null, null, null);
	trailer = new Node(null, null, header);
	header.right = trailer;
    }

    //check the list is empty or not
    public boolean isEmpty() {
	return size == 0;
	//if size = 0, list is empty
    }

    /**
     * this method use to get the size of the list
     *
     * @return size
     */
    public int size() {
	return size;
    }

    /**
     * add Node to first of the list
     *
     * @param newNode
     */
    public void addFirst(Node newNode) {
	header.right.left = newNode;
	newNode.right = header.right;
	newNode.left = header;
	header.right = newNode;
    }

    /**
     * add Node to the end of the list
     *
     * @param newNode
     */
    public void addLast(Node newNode) {
	trailer.left.right = newNode;
	newNode.left = trailer.left;
	newNode.right = trailer;
	trailer.left = newNode;
    }

    /**
     * this method use to add element to the list in between given node and sort
     * them depend on their point
     *
     * @param data
     */
    public void addBetween(Gamer data) {
	//create new node to add
	Node newbie = new Node(data, trailer, header);
	int point = data.getPoint();
	//if list is empty
	if (isEmpty()) {
	    header.right = newbie;
	    newbie.left = header;
	    newbie.right = trailer;
	    trailer.left = newbie;
	} else {
	    int pointOfHeader = header.right.getGamer().getPoint();
	    int pointOfTrailer = trailer.left.getGamer().getPoint();
	    //if input point < point of trailer, add new trailer
	    if (point < pointOfTrailer) {
		addLast(newbie);
	    } //if input point > point of header, add new header
	    else if (point > pointOfHeader) {
		addFirst(newbie);
	    } //normal case, go through the list and compare every node until get right position
	    else {
		Node currentNode = trailer.left;
		while (currentNode.getGamer().getPoint() < newbie.getGamer().getPoint()) {
		    currentNode = currentNode.left;
		}
		currentNode.right.left = newbie;
		newbie.left = currentNode;
		newbie.right = currentNode.right;
		currentNode.right = newbie;
	    }
	}
	size++;
    }

    /**
     * this method use to remove Node with the info Node given and return it
     *
     * @param node
     * @return info of node
     */
    private Gamer remove(Node node) {
	Node left = node.left;
	Node right = node.right;
	left.setRight(right);
	right.setLeft(left);
	size--;
	return node.getGamer();
    }

    /**
     * this method will get the first gamer of the list
     *
     * @return Gamer
     */
    public Gamer first() {
	if (isEmpty()) {
	    return null;
	}
	return header.getRight().getGamer();
    }

    /**
     * this method will remove first gamer of the list
     */
    public void removeFirst() {
	if (isEmpty()) {
	    System.out.println("The list is empty!!");
	} else {
	    remove(header.getRight());
	}
    }

    /**
     * this method will print all gamer in the list by go through the list
     */
    public void printList() {
	//begin in the first node after header
	Node currentNode = header.getRight();
	//this loop will scan every node and it will stop until meet the trailer
	while (currentNode != trailer) {
	    System.out.println(currentNode.getGamer() + "\n");
	    currentNode = currentNode.getRight();
	}
    }

    /**
     * this method will go through the list and check email of gamer if input
     * email equal email on the list, it will return that gamer have this email
     * if don't, return null
     *
     * @param email
     * @return gamer
     */
    public Gamer searchGamerByEmail(String email) {
	for (Node n = header.right; n != trailer; n = n.right) {
	    if (n.getGamer().getEmail().equalsIgnoreCase(email)) {
		return n.getGamer();
	    }
	}
	return null;
    }

    /**
     * this method will go through the list and check email of gamer if input
     * email equal email on the list, it will return that node have this email
     * if don't, return null
     *
     * @param email
     * @return Node
     */
    public Node searchGamerToDelete(String email) {
	for (Node n = trailer.left; n != header; n = n.left) {
	    if (n.getGamer().getEmail().equalsIgnoreCase(email)) {
		return n;
	    }
	}
	return null;
    }

    /**
     * this method will delete the node of the Gamer have the input email
     *
     * @param email
     * @return Gamer has been remove
     */
    public Gamer removeNode(String email) {
	Node delNode = searchGamerToDelete(email);
	if (delNode != null) {
	    return remove(delNode);
	}
	return null;
    }

    /**
     * this method will get the list and write all the Gamer info to CSV file
     *
     * @param fileName
     * @throws java.io.IOException
     */
    public void writeToCSVfile(String fileName) throws IOException {
	FileWriter fr = null;
	try {
	    fr = new FileWriter(fileName);
	    fr.append("Email, Point\n");
	    for (Node n = header.right; n != trailer; n = n.right) {
		String data = String.format("%s, %d\n", n.getGamer().getEmail(), n.getGamer().getPoint());
		fr.append(data);
	    }
	} catch (IOException e) {
	    System.out.println("Something wrong with writing to file!!");
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