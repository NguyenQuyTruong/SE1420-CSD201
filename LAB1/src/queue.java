
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140279
 */
public class queue {

    LinkList list = new LinkList();

    /**
     * contractor of queue
     */
    public queue() {
    }

    /**
     * insert
     *
     * @param data
     */
    public void insert(manageGamer data) {
        list.addBetween(data);
    }

    /**
     * delete a top gamer
     */
    public void deleteTop() {
        list.removeFirst();
    }

    /**
     * delete user by email
     *
     * @param email
     * @return
     */
    public manageGamer deleteUser(String email) {
        manageGamer data = list.removeFirst();
        return data;
    }

    /**
     * update user
     *
     * @param email
     * @param point
     */
    public void updateUser(String email, int point) {
        manageGamer data = list.searchUserByEmail(email);
        if (data == null) {
            System.out.println("Not found users for this!!");
            return;
        } else {
            data.setPoint(point);
            deleteUser(email);
            list.addBetween(data);
            System.out.println("update successfull");
            System.out.println("email: " + email + ", new point: " + data.getPoint());
        }
    }

    /**
     * search user by email
     *
     * @param email
     * @return
     */
    public manageGamer searchUser(String email) {
        manageGamer data = list.searchUserByEmail(email);
        return data;
    }

    /**
     * get first place
     *
     * @return
     */
    public manageGamer getTop() {
        return list.getFisrt();
    }

    /**
     * remove
     *
     * @return
     */
    public manageGamer removeTop() {
        return list.removeFirst();
        /**
         * read file because it appear more in void main
         */
    }

    public void ReadFile(queue q, String fileName) {
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);
            while (bf.ready()) {
                String s = bf.readLine();
                String[] arr = s.split(", ");
                if (!(arr[1].equalsIgnoreCase("point :"))) {
                    q.insert(new manageGamer(arr[0], Integer.valueOf(arr[1])));
                }
            }
        } catch (IOException e) {
            System.out.println("File not exist!!");
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println("Something wrong with Reading file");
            }
        }
    }

    public void write(String namefile) throws IOException {
        list.writeToCSVfile(namefile);
    }

}
