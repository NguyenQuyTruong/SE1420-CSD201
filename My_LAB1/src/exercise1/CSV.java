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
                String[] rowData = line.split(",");
                if (rowData.length < 2) {
                    throw new IOException("errow data");
                }
                String email = rowData[0];
                String unpoint = rowData[1];
                long point = Long.parseLong(unpoint.trim());
                Gamer g = new Gamer(email, point);
                queue.insert(g);
            }
            System.out.println("Finished read CSV file");
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
