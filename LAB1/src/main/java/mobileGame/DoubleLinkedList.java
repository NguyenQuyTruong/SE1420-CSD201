/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobileGame;

/**
 *
 * @author nhoxr
 */
public class DoubleLinkedList {

    //create class Node
    private class Node {

	private Gamer gamer;
	private Node right = null;
	private Node left = null;

	//constructor
	public Node(Gamer gamer, Node right, Node left) {
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
    private Node header, trailer;

    //create DoubleLinkedList constructor
    public DoubleLinkedList() {
	header = new Node(null, null, null);
	trailer = new Node(null, null, header);
	header.right = trailer;
    }

    //check the list is empty or not
    public boolean isEmpty() {
	return (header.right == trailer);
	//if next to header is trailer(null) it mean not thing in the list
    }
}
