
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main{
    public static PriorityQueue queue;

    /**
     * Method for adding new Player to queue
     *
     * @param email
     * @param point
     */
    public void insertNewPlayer(String email, String point) {
	try {
	    int checkPoint = Integer.parseInt(point.trim());
	    queue.push(new Player(email, checkPoint));
	} catch (NumberFormatException e) {
	    System.out.println("Point must be integer!!");
	}
    }

    /**
     * Method for outputting the point and the email inputed
     *
     * @param email
     */
    public void searchPlayer(String email) {
	Player data = queue.searchPlayer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Email: " + email + ", Point: " + data.getPoint());
	}
    }

    /**
     * Method for deleting player on inputed email
     *
     * @param email
     */
    public void deletePlayer(String email) {
	Player data = queue.deletePlayer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Remove " + email + " successful!");
	}
    }

    /**
     * Method for Updating point on inputed email
     *
     * @param email
     * @param point
     */
    public void updatePlayer(String email, String point) {
	try {
	    int newPoint = Integer.parseInt(point.trim());
	    queue.updatePlayer(email, newPoint);
	} catch (NumberFormatException e) {
	    System.out.println("Point must be Integer!!");
	}
    }

    /**
     * Method for outputting the Player with the highest point
     */
    public void getTopPlayer() {
	Player data = queue.getTop();
	System.out.println("Top 1 Player:");
	System.out.println("Email: " + data.getEmail() + ", Point: " + data.getPoint());
    }

    /**
     * Method for deleting the top Player
     */
    public void deleteTopPlayer() {
	queue.deleteTop();
	System.out.println("Remove top successful!!");
    }

    /**
     * Method for saving to file
     *
     * @param fileName
     * @throws java.io.IOException
     */
    public void saveToFile(String fileName) throws IOException {
	queue.writeToCSVfile(fileName);
    }
    
    public static void main(String[] args) throws IOException, FileNotFoundException{
        String inputFile = "";
        String outputFile = "";
        Main mainStuff = new Main();
        for(int i = 0; i < args.length; i ++){
             try {
                switch(args[i]){
                    case "-r":
                        queue = new PriorityQueue();
                        inputFile = args[i + 1];
                        queue.readFile(queue, inputFile);
                        break;
                    case "-a":
                        mainStuff.insertNewPlayer(args[i + 1], args[i + 2]);
                        mainStuff.saveToFile(outputFile);
                        break;
                    case "-u":
                        mainStuff.updatePlayer(args[i + 1], args[i + 2]);
                        mainStuff.saveToFile(outputFile);
                        break;
                    case "-dt":
                        mainStuff.deleteTopPlayer();
                        mainStuff.saveToFile(outputFile);
                        break;
                    case "-d":
                        mainStuff.deletePlayer(args[i+1]);
                        mainStuff.saveToFile(outputFile);
                        break;
                    case "-g":
                        mainStuff.searchPlayer(args[i+1]);
                        break;
                    case "-s":
                        outputFile = args[i + 1];
                        queue.readFile(queue, inputFile);
                        break;
                    case "-t":
                        queue.getTop();
                        break;
                    case "-h":
                        System.out.println("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
"java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
                        break;
                }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("-----Can't find argument to execute-----");
        }
             System.out.println("File inputted: " + inputFile);
             System.out.println("File outputted: " + outputFile);
        }  
    }
    
}
