
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
     *Get the List and write the data down to the file.
     * 
     * @param fileName
     */
    public void writeToFile ( String fileName) {
        FileWriter file = null;
        try{
            file = new FileWriter(fileName);
            file.append("Email, Point(s)\n");
            for(DoubleLinkedList.Node n = head.getNext(); n!= trail; n = n.getNext()){
                String data = String.format("%s, %d\n", n.getPlayer().getEmail(), n.getPlayer().getPoint());
                file.append(data);
            }
        }catch(IOException e){
            System.out.println("---Error: Something has gone wrong---");
        } finally {
            try {
                if(file != null){
                    file.close();
                }
            } catch (Exception e) {
                System.out.println("File doesn't exist.");
            }
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
                    queue.insertPlayer(new Player(arr[0], Integer.valueOf(arr[0])));
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
        printList();
    }
}
