package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CSV {
	/**
	 * Read csv file data and insert it to priority queue
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
					String[] rowData = line.split(","); // split data into array using ","
					if (rowData.length < 2) { // catch this error before it break your program
						throw new IOException("Not enough data in a row (csv file)");
					}

					String email = rowData[0];
					String unparsedPoint = rowData[1];
					long point = Long.parseLong(unparsedPoint.trim());
					queue.insert(email, point);
				}catch(NumberFormatException e) {
					// no need to do anything, use this exception to skip header
				}
				
			}

			System.out.println("Finish reading csv file");

		} catch (FileNotFoundException e) {
			System.out.println("Csv file not found, please check again!");
		} finally {
			bufferedReader.close();
		}
	}

	/**
	 * write queue to csv file
	 * @param queue
	 * @param path
	 * @throws IOException
	 */
	public static void WriteQueueIntoCSV(PriorityQueue queue, String path) throws IOException {
		queue.exportCSV(path);

	}
}
