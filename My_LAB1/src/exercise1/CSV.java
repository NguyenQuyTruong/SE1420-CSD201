/*
 * Read and write queue to CSV file
 * 
 * 
 */
package exercise1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.IIOException;

/**
 *
 *
 */
public class CSV {

    /**
     * Read CSV file data and insert it to priority queue
     *
     * @param queue
     * @param csvPath
     * @throws IOException
     */
    public static void ReadAndPushToQueue(PriorityQueue queue, String csvPath) throws IOException {
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(csvPath));
            while ((line = bufferedReader.readLine()) != null) {
                try {
                    String[] rData = line.split(",");
                    if (rData.length < 2) {
                        throw new IOException("not enough data in row");
                    }
                    String email = rData[0];
                    String uPoint = rData[1];
                    long point = Long.parseLong(uPoint.trim());
                    Gamer g = new Gamer(email, point);
                    queue.insert(g);
                } catch (NumberFormatException e) {

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File CSV not found");
        } finally {
            bufferedReader.close();
        }
    }

    /**
     * write queue to CSV file
     *
     * @param queue
     * @param path
     * @throws IOException
     */
    public static void WriteQueueIntoCSV(PriorityQueue queue, String path) throws IOException {
        queue.writeToCSV(path);

    }
}
