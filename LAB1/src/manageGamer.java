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
private String userGamer;
private int point;
    public manageGamer() {
    }

    public manageGamer(String userGamer, int point) {
        this.userGamer = userGamer;
        this.point = point;
    }

    public String getUserGamer() {
        return userGamer;
    }

    public void setUserGamer(String userGamer) {
        this.userGamer = userGamer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
