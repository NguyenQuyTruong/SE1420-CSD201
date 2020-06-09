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
public class ProblemSolve {
    SortLinkedList list = new SortLinkedList();
    final String filename = "player.data";

    private void addNewPlayer(String email, String point) {
        try {
            int pPoint = Integer.parseInt(point.trim());
            list.add(email, pPoint);
        } catch (Exception e) {
        }
    }
    private void GetPointPlayer(String email) {
        Player rs=list.SearchPlayerEmail(email);
        if (rs == null) {
            System.out.println("CAN'T find " + email + " please try again!");
        } else {
            System.out.println(email + " : " + rs.getPoint() + " points");
        }
    }
     private void removePlayer(String email) {
        list.removePlayer(email);
    }

    private void removeMaxPointP() {
        list.RemoveMaxPointPlayer();
    }

    private void searchMaxPointPlayer() {
        list.SearchMaxpointPlayer();
    }

    private void updatePlayer(String email, String point) {
        try {
            int ppoint = Integer.parseInt(point.trim());
            list.UpdatePlayer(email, ppoint);
        } catch (Exception e) {
        }
    }
}
