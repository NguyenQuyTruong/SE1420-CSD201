/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class queue {

    LinkList list = new LinkList();

    public queue() {
    }

    public void insert(manageGamer data) {
        list.addBetween(data);
    }

    public LinkList getTop() {
        return list;
    }

    public void deleteTop() {
        list.removeFirst();
    }

    public manageGamer deleteUser(String email) {
        manageGamer data =list.removeFirst();
        return data;
    }

    public void updateUser(String email, int point) {
       manageGamer data = list.searchUserByEmail(email);
	if (data == null) {
	    System.out.println("Not found users for this!!");
	    return;
	} else {
	    data.setPoint(point);
	       deleteUser(email);
	    list.addBetween(data);
	    System.out.println("Update point successfull");
	    System.out.println("Email: " + email + ", New point: " + data.getPoint());
	}
    }

    public manageGamer searchUser(String email) {
          manageGamer data = list.searchUserByEmail(email);
          return data;
    }

    public manageGamer getTop() {
    }

    public manageGamer removeTop() {
       
}
