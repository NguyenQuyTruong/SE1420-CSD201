/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author redra
 */
public class Player {
    //Player components + get, set
    private String email;
    private int point;
    
    public Player(){}
    
    public Player(String email, int point){
        this.email = email;
        this.point = point;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }
    
    @Override
    public String toString() {
        return "Gamer{" + "email= "+ email + ", point= " + point + '}';
    }
}
