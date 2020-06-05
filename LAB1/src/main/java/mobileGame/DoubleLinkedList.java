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
    private static class Node<Gamer> {

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
    private int size = 0;

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
     * this method use to add element to the list in between given node
     * @param gamer
     * @param left
     * @param right
     */
    private void addBetween(Gamer gamer, Node<Gamer> left, Node<Gamer> right) {
	Node<Gamer> newbie = new Node<>(gamer, left, right);
	left.setRight(newbie);
	right.setLeft(newbie);
	size++;
    }

    /**
     * this method use to remove Node with the info Node given and return it
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
}
