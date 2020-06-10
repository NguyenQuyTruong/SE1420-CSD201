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

    public void insertUser(User data) {
	add(data);
    }

    public void deleteUser(String email) {
	deleteUserNode(email);
    }

    public void updateUser(String email, int point) {
	updateUserNode(email, point);
    }

    public void searchUser(String email) {
	displayPointUserEmail(email);
    }

    public void getTop() {
	displayPointTopUser();
    }

    public void removeTop() {
	if (isEmpty()) {
	    System.out.println("The list is empty. Please add new user to use this feature");
	} else {
	    removeFirst();
	}
    }

    public void writeUserToFile(String fileName) {
	writeData(this, fileName);
    }
}
