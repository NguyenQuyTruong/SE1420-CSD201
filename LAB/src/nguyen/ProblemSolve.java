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
}
