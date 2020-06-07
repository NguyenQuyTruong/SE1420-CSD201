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
public class Exercise1 {

    PriorityQueue queue;

    /**
     * this method use to add new Gamer to queue
     * @param email
     * @param point
     */
    public void insertNewGamer(String email, String point) {
	try {
	    int checkPoint = Integer.parseInt(point.trim());
	    queue.push(new Gamer(email, checkPoint));
	} catch (NumberFormatException e) {
	    System.out.println("Point must be integer!!");
	}
    }
}
