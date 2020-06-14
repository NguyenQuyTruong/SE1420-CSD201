/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManager;

/**
 *
 * @author minhv
 */
public class PriorityQueue extends UserManager.DoublyLinkedList {

    public PriorityQueue() {
    }
    
    /**
     * Insert new user, use add function from Doubly LinkedList
     * @param data 
     */
    public void insertUser(User data) {
	add(data);
    }

    /**
     * Delete user, use delete function from Doubly LinkedList
     * @param email 
     */
    public void deleteUser(String email) {
	deleteUserNode(email);
    }

    /**
     * Update user base on email inputted, use update function from Doubly LinkedList
     * @param email
     * @param point 
     */
    public void updateUser(String email, int point) {
	updateUserNode(email, point);
    }

    /**
     * Search user base on email, use  function from Doubly LinkedList
     * @param email 
     */
    public void searchUser(String email) {
	displayPointUserEmail(email);
    }

    /**
     * Get top user, use top function from Doubly LinkedList
     */
    public void getTop() {
	displayPointTopUser();
    }

    /**
     * Remove top user, use remove top function from Doubly LinkedList
     */
    public void removeTop() {
	if (isEmpty()) {
	    System.out.println("The list is empty. Please add new user to use this feature");
	} else {
	    removeFirst();
	}
    }

    /**
     * Write csv file
     * @param fileName 
     */
    public void writeUserToFile(String fileName) {
	writeData(this, fileName);
    }
}
