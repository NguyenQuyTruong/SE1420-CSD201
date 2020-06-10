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

    public manageGamer(String userGamer, int point) {
        this.userEmail = userGamer;
        this.point = point;
    }
    // getter & setter
    public String getUserGamer() {
        return userEmail;
    }

    public void setUserGamer(String userGamer) {
        this.userEmail = userGamer;
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
