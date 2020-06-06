/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

/**
 *
 * @author nhoxr
 * @param <Gamer>
 */
public class DoubleLinkedList<Gamer> {

    //create class Node
    public class Node<Gamer> {

	private Gamer gamer;
	private Node<Gamer> right = null;
	private Node<Gamer> left = null;

	//constructor
	public Node(Gamer gamer, Node<Gamer> right, Node<Gamer> left) {
	    this.gamer = gamer;
	    this.right = right;
	    this.left = left;
	}

	//getter and setter for Node
	public Gamer getGamer() {
	    return gamer;
	}

	public void setGamer(Gamer gamer) {
	    this.gamer = gamer;
	}

	public Node<Gamer> getRight() {
	    return right;
	}

	public void setRight(Node<Gamer> right) {
	    this.right = right;
	}

	public Node<Gamer> getLeft() {
	    return left;
	}

	public void setLeft(Node<Gamer> left) {
	    this.left = left;
	}
    }

    //create 2 main node
    public Node<Gamer> header;
    public Node<Gamer> trailer;
    public int size = 0;

    //create DoubleLinkedList constructor
    public DoubleLinkedList() {
	header = new Node<>(null, null, null);
	trailer = new Node<>(null, null, header);
	header.right = trailer;
    }

    //check the list is empty or not
    public boolean isEmpty() {
	return size == 0;
	//if size = 0, list is empty
    }

    /**
     * this method use to get the size of the list
     * @return size
     */
    public int size() {
	return size;
    }
    /**
     * this method use to add element to the list in between given node
     *
     * @param gamer
     * @param left
     * @param right
     */
    private void addBetween(Gamer gamer, Node<Gamer> right, Node<Gamer> left) {
	//create new node to add
	Node<Gamer> newbie = new Node<>(gamer, right, left);
	left.setRight(newbie);
	right.setLeft(newbie);
	size++;
    }

    /**
     * this method use to remove Node with the info Node given and return it
     *
     * @param node
     * @return info of node
     */
    private Gamer remove(Node<Gamer> node) {
	Node<Gamer> left = node.left;
	Node<Gamer> right = node.right;
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
     *
     * @return Gamer
     */
    public Gamer removeFirst() {
	if (isEmpty()) {
	    return null;
	}
	return remove(header.getRight());
    }

    /**
     * add Gamer to first of the list
     *
     * @param data
     */
    public void addFirst(Gamer data) {
	addBetween(data, header.getRight(), header);
    }

    /**
     * add Gamer to the last of the list
     *
     * @param data
     */
    public void addLast(Gamer data) {
	addBetween(data, trailer, trailer.getLeft());
    }

    /**
     * this method will print all gamer in the list by go through the list
     * @param list
     */
    public void printList(DoubleLinkedList list) {
	//begin in the first node after header
	Node currentNode = header.getRight();
	//this loop will scan every node and it will stop until meet the trailer
	while (currentNode != trailer) {
	    System.out.println(currentNode.getGamer() + "\n");
	    currentNode = currentNode.getRight();
	}
    }
    
    public void addGamerSortByPoint(int point) {
	
    }
}
