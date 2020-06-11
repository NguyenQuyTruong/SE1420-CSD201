
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class PriorityQueue extends DoubleLinkedList{
    public PriorityQueue(){}
    /**
     * Method for Insert Player
     * @param data 
     */
    public void insertPlayer(Player data){
        add(data);
    }
    /**
     * Method for Update Player
     * @param email
     * @param point 
     */
    public void updatePlayer(String email, int point){
        updateNode(email, point);
    }
    /**
     * Method for delete Player
     * @param email 
     */
    public void deletePlayer(String email){
        deletePlayerNode(email);
    }
    /**
     * Method for Search Player
     * @param email 
     */
    public void searchPlayer(String email){
        displayPointByEmail(email);
    }
    /**
     * Method for Getting data of the top Player
     * @return Player
     */
    public void getTop(){
        displayTopPlayer();
    }
    /**
     * Method for Deleting the top Player
     */
    public void removeTop(){
        if(isEmpty()){
            System.out.println("The List is Empty.... try input some data first.");
        }else{
            removeFirst();
        }
    }
    /**
     * Method for Saving the data back to the .csv file
     * @param fileName 
     */
    public void writeToCSV(String fileName) {
        writeToFile(fileName);
    }
    /**
     * Method use to read file.
     * 
     * @param queue
     * @param fileName 
     */
    public void readFile(PriorityQueue queue, String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (br.ready()){
                String s = br.readLine();
                String[] arr = s.split(", ");
                if(!(arr[1].equalsIgnoreCase("point"))){
                    queue.insertPlayer(new Player(arr[0], Integer.valueOf(arr[1])));
                }
            }
        }catch(IOException e ){
            System.out.println("---File not exist---");
        } finally{
            try {
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("---Something when wrong when reading file---");
            }
        }
    }
}
