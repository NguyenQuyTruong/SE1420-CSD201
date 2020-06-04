package problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV {
	/**
	 * Read csv file data and insert it to priority queue
	 * @param queue
	 * @param csvPath
	 * @throws IOException 
	 */
	public static void ReadAndPushToQueue(PriorityQueue queue, String csvPath) throws IOException {
		
		BufferedReader bufferedReader = null;
		String line = "";
		
		try {
			bufferedReader = new BufferedReader(new FileReader(csvPath));
			while((line = bufferedReader.readLine()) != null) {
				String[] rowData = line.split(","); //split data into array using ","
				if (rowData.length < 2) { //catch this error before it break your program
					throw new IOException("Not enough data in a row (csv file)");
				}
				
				String email = rowData[0];
				long point =  Long.parseLong(rowData[1]);
				queue.insert(email, point);
			}
			
			System.out.println("Finish reading csv file");
			
		}catch(FileNotFoundException e) {
			System.out.println("Csv file not found, please check again!");
		}finally {
			bufferedReader.close();
		}
	}
}
