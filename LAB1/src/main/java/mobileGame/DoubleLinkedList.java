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
	private Node right;
	private Node left;
	
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
}
