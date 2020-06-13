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
public class User {
    private String email;
    private int point;

    public User() {
	email = "";
	point = 0;
    }

    
    public User(String email, int point) {
	this.email = email;
	this.point = point;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getPoint() {
	return point;
    }

    public void setPoint(int point) {
	this.point = point;
    }

    @Override
    public String toString() {
	return email + ", " + point;
    }
}