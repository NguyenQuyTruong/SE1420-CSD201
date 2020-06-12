package exercise1;

import java.io.IOException;

/**
 *
 * @author Khanh Hoa
 */
public class Excersise1 {

    private static final String storageFile = "excersise1.data";
    PriorityQueue queue;

    public Excersise1() {
    }

    /**
     * insert player game
     *
     */
    public void Insert(String email, String point) {
        try {
            long rpoint = Long.parseLong(point.trim());
            Gamer g = new Gamer(email, rpoint);
            queue.insert(g);
        } catch (NumberFormatException e) {
            System.out.println("error: point must be number");
        }
    }

    /**
     * Delete player by email
     *
     * @param email
     */
    public void Delete(String email) {
        queue.Delete(email);
    }

    /**
     * get point of user
     *
     * @param email
     */
    public void GetPoint(String email) {
        Long point = queue.GetPointOfUser(email);
        if (point == null) {
            System.out.println("can't find email");
        } else {
            System.out.println(point);
        }
    }

    /**
     * update new user player
     *
     * @param email, point
     *
     */
    public void Update(String email, String point) {
        try {
            long newPoint = Long.parseLong(point);
            queue.Update(email, newPoint);
        } catch (Exception e) {
            System.out.println("error, point must be number");
        }
    }

    /**
     * get top player
     */
    public void GetTop() {
        queue.findTheTopUser();
    }

    /**
     * delete top player user
     */
    public void DeleteTop() {
        queue.deleteTheTopUser();
    }

    /**
     * save data to CSV
     *
     * @param path
     */
    public void SaveToCSV(String path) {
        try {
            CSV.WriteQueueIntoCSV(queue, path);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void ParseArgument(String[] args) {
        boolean saveData = false;
        String savePath = null;
        try {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-r":
                        queue = new PriorityQueue();
                        CSV.ReadAndPushToQueue(queue, args[i+1]);
                        break;
                    case "-a":
                        Insert(args[i + 1], args[i + 2]);
                        break;
                    case "-d":
                        Delete(args[i + 1]);
                        break;
                    case "-u":
                        Update(args[i + 1], args[i + 2]);
                        break;
                    case "-dt":
                        DeleteTop();
                        break;
                    case "-t":
                        GetTop();
                        break;
                    case "-g":
                        GetPoint(args[i + 1]);
                        break;
                    case "-s":
                        saveData = true;
                        savePath = args[i + 1];
                        break;
                    default:
                        break;
                }
            }
            if(saveData){
                SaveToCSV(savePath);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments to execute commands");
        } catch (IOException e) {
            System.out.println("error reading csv file");
        }
    }
}
