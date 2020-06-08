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
public class Test {

    public static void main(String[] args) throws Exception {
	LAB1_1.PriorityQueue list = new LAB1_1.PriorityQueue();
	User user1 = new User("1", 1);
	User user2 = new User("2", 2);
	User user3 = new User("3", 3);
	User user4 = new User("4", 4);
	User user5 = new User("5", 5);
	User user6 = new User("6", 6);
	User user7 = new User("7", 7);
	User user8 = new User("8", 8);
	User user9 = new User("9", 9);
	User user10 = new User("10", 10);

	list.insertUser(user1);
	list.insertUser(user3);
	list.insertUser(user6);
	list.insertUser(user2);
	list.insertUser(user5);
	list.deleteUser("126");
	list.updateUser("345", 2);

	list.displayUser();
    }
}
