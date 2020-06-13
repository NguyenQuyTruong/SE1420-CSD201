/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SE140279
 */
public class manageGamer {
    //contructor element file csv
private String userEmail;
private int point;
    public manageGamer() {
    }

    public manageGamer(String userEmail, int point) {
        this.userEmail = userEmail;
        this.point = point;
    }
    // getter & setter
    public String getUserEmail() {
        return userEmail;
    }

    public void setUser(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    // toString
    public String toString() {
        return "user {" + " email : " +userEmail+ ", point ="+ point+ "}";
    }
    
}
