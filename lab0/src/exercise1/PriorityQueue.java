/*
 * This class has these methods: 
 * insert information of a game player to the queue so that the queue is sorted as decreasing the point of player.
 * That means the player who has the highest point will be in the head.
 * search game player by email.
 * delete a game player account (use method search game player by email to identify which account is deleted).
 * update a game player account (use method search game player by email to identify account updated)
 * find and delete the top user.
 * write queue to CSV files.
 */
package exercise1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Khanh Hoa
 */
public class PriorityQueue implements Serializable {

    private static final long serialVersionUID = 1L;
    Node<Gamer> node;
    private DoublyLinkedList<Gamer> list = new DoublyLinkedList<>();

    /**
     * Insert into Priority Queue
     *
     * @param g
     */
    public void insert(Gamer g) {
        //list is decrease
        //if list is empty, insert between head and tail
        if (list.isEmpty()) {
            list.addFirst(g);
        }

        //if new point<tail point then add new point in last
        if (g.point < list.trailer.getPrev().getElement().getPoint()) {
            list.addLast(g);
        }
        //if new point>head point then add new point in front of list
        if (g.point > list.header.next.getElement().getPoint()) {
            list.addFirst(g);
        }
        //normal case

        if (g.point > list.trailer.prev.getElement().getPoint() && g.point < list.header.next.getElement().getPoint()) {
            node = list.header.getNext();
            while (node.getElement().getPoint() > g.getPoint()) {
                node = node.getNext();
            }
            list.addBetween(g, node.getPrev(), node);
        }
    }

    /**
     * Search Game player By Email
     *
     * @param email
     * @return node
     */
    public Node<Gamer> searchByEmail(String email) {
        node = list.header.getNext();
        while (!(node.getElement().getEmail().contentEquals(email)) && (node != list.trailer)) {
            node = node.getNext();
        }
        return node;
    }

    /**
     * Delete a game player account
     *
     * @param email
     */
    public void Delete(String email) {
        if (node == list.trailer) {
            System.out.println("Don't have this email in list!");
        } else {
            node = searchByEmail(email);

            list.remove(node);
            System.out.println("Remove email: " + email + " completed");
        }
    }

    /**
     * Update a game player account
     *
     * @param email
     * @param point
     */
    public void Update(String email, int point) {
        node = searchByEmail(email);
        if (node == list.trailer) {
            System.out.println("Don't have this email in list");
        } else {
            node.getElement().setPoint(point);
            System.out.println("Update email:" + email + " with the point:" + point + " completed");
        }
    }

    /**
     * Get point of user
     *
     * @param email
     *
     */
    public void Search(String email) {
        node = searchByEmail(email);
        if (node == list.trailer) {
            System.out.println("Don't have this email in list");
        } else {
            System.out.println("Email: " + email);
            System.out.println("Point: " + node.getElement().getPoint());
        }
    }

    /**
     * Find the Top User
     *
     * @param
     *
     */
    public void findTheTopUser() {
        if (list.isEmpty()) {
            System.out.println("Player information is null");
        }
        if (!(list.isEmpty())) {
            System.out.println("Player has the highest point is: " + list.header.getNext().getElement().getEmail());
            System.out.println("Highest point:" + list.header.getNext().getElement().getPoint());
        }
    }

    /**
     * Delete the Top User
     *
     * @param
     *
     *
     */
    public void deleteTheTopUser() {
        if (list.isEmpty()) {
            System.out.println("Player information is null");
        }
        if (!(list.isEmpty())) {
            list.remove(list.header.getNext());
            System.out.println("Delete completed");
        }
    }

    /**
     * Write queue to CSV
     *
     * @param path
     * @throw IOException
     *
     */
    public void writeToCSV(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        node = list.header.getNext();
        while (node != list.trailer) {
            String data = String.format("%s,%d\n", node.getElement().getEmail(), node.getElement().getPoint());
            writer.append(data);
        }
        writer.flush();
        writer.close();
        System.out.println("Saved data to CSV file");
    }
}
