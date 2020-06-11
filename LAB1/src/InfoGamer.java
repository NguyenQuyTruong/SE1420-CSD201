/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Chi  Cuong
 */
public class InfoGamer {
    /**
     * Mobile game include: Email, Point of player
     */
    private String email;
    private long point;

    /**
     * This is constructor without parameter 
     */
    public InfoGamer() {
    }

    /**
     * This is constructor parameter to build a game entry with 2 given parameter
     * @param email
     * @param point 
     */
    public InfoGamer(String email, long point) {
        this.email = email;
        this.point = point;
    }
    /**
     * it use to return email
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * it use to set email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * it use to return point
     * @return 
     */
    public long getPoint() {
        return point;
    }
    /**
     * I use to set point
     * @param point 
     */
    public void setPoint(long point) {
        this.point = point;
    }
  
}
