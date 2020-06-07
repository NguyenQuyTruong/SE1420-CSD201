/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen;

/**
 *
 * @author ADMIN
 */
public class Player {
    private String Email;
    private String Point;
    Player nextPlayer;
    Player beforePlayer;

    public Player() {
    }

    public Player(String Email, String Point, Player nextPlayer, Player beforePlayer) {
        this.Email = Email;
        this.Point = Point;
        this.nextPlayer = nextPlayer;
        this.beforePlayer = beforePlayer;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public Player getBeforePlayer() {
        return beforePlayer;
    }

    public void setBeforePlayer(Player beforePlayer) {
        this.beforePlayer = beforePlayer;
    }
    @Override
   public String toString(){
        return String.format("%-15s%-10d",Email, Point);
    }
}
