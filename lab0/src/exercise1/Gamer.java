/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.io.Serializable;

/**
 *
 * @author Khanh Hoa
 */
public class Gamer implements Serializable{
    private static final long serialVersionUID = 1L;
    String email;
    int point;

    public Gamer() {
    }

    public Gamer(String email, int point) {
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
    
}
