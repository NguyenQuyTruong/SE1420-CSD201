/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author minhv
 */
public class PriorityQueue extends Lab1_1.DoublyLinkedList {

    public void insertUser(User data) {
	add(data);
    }

    public void deleteUser(String email) throws Exception {
	deleteUserNode(email);
    }

    public void updateUser(String email, int point) throws Exception {
	updateUserNode(email, point);
    }

    public void searchUser(String email) throws Exception {
	displayPointUserEmail(email);
    }
    
    public void getTop() throws Exception {
	displayPointTopUser();
    }
    
    public void removeTop() {
	removeLast();
    }

    public void displayUser() {
	printlist(this);
    }
}
