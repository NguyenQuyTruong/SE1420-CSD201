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
    private class Node<Gamer> {

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
    private Node header, trailer;

    //create DoubleLinkedList constructor
    public DoubleLinkedList() {
	header = new Node<>(null, null, null);
	trailer = new Node<>(null, null, header);
	header.right = trailer;
    }

    //check the list is empty or not
    public boolean isEmpty() {
	return (header.right == trailer);
	//if next to header is trailer(null) it mean not thing in the list
    }
    
    /**
     * 
     */
    private void addBetween() {
	
    }
}
