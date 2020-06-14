
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class PriorityQueue extends DoubleLinkedList{
    private DoubleLinkedList list = new DoubleLinkedList();

    /**
     * Method for adding new Player to the List
     *
     * @param Player data
     */
    public void push(Player data) {
	list.addBetween(data);
//	System.out.println("push Player data successful!!");
    }

    /**
     * Method for getting the Top Player
     *
     * @return Player
     */
    public Player getTop() {
	return list.first();
    }

    /**
     * Method for deleting the Top Player
     */
    public void deleteTop() {
	list.removeFirst();
    }

    /**
     * Method for deleting a Player by inputted
     * @param email
     * @return Player
     */
    public Player deletePlayer(String email) {
	Player data = list.removeNode(email);
	return data;
    }

    /**
     * Method for returning the Player data by Email
     * @param email
     * @return Player
     */
    public Player searchPlayer(String email) {
	Player data = list.searchPlayerByEmail(email);
	return data;
    }

    /**
     * Method for updating inputted email's point
     * @param email
     * @param point
     */
    public void updatePlayer(String email, int point) {
	Player data = list.searchPlayerByEmail(email);
	if (data == null) {
	    System.out.println("Not found!!");
	    return;
	} else {
	    data.setPoint(point);
	    deletePlayer(email);
	    list.addBetween(data);
	    System.out.println("Update point successfull");
	    System.out.println("Email: " + email + ", New point: " + data.getPoint());
	}
    }

    /**
     * Method use to Read file and push the data to queue
     * @param queue
     * @param fileName 
     */
    public void readFile(PriorityQueue queue, String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (br.ready()){
                String line = br.readLine();
                String[] arr = line.split(", ");
                if(!(arr[1].equalsIgnoreCase("point"))){
                    queue.push(new Player(arr[0], Integer.valueOf(arr[1])));
                }
            }
        } catch (Exception e) {
            System.out.println("---File not exist---");
        } finally{
            try{
                if(fr != null){
                    fr.close();
                } else if (br != null){
                    br.close();
                }
            } catch(IOException e){
                System.out.println("---Some Error Has Occur---");
            }
        }
    }
    /**
     * Method for Print the whole List
     * @return List
     */
    public void printDaList(){
        list.printList();
    }
}
