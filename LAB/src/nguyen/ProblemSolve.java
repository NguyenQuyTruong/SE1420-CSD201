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
     private void saveFile() {
       FileDao.writeFile(list, filename);
    }

    private void loadFile() {
        FileDao.readFile(list, filename);
    }
    public void getArguments(String[] args) {

        try {
            switch (args[0]) {
                case "-r": //read csv
                    loadFile();
                case "-a": //add new user
                    addNewPlayer(args[1], args[2]);
                    break;
                case "-d": //delete a user
                    removePlayer(args[1]);
                    break;
                case "-u":
                    updatePlayer(args[1], args[2]);
                    break;
                case "-g":
                    GetPointPlayer(args[1]);
                    break;
                case "-t":
                    searchMaxPointPlayer();
                    break;
                case "-dt":
                    removeMaxPointP();
                    break;
                case "-s":
                    saveFile();
                    break;
                default:
                    System.out.println("Command not found, try again!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough argument");
        } catch (Exception e) {
            System.out.println("There is an error happen, please check your csv file or any input parameter");
        }

    }
}
