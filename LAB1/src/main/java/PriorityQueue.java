
public class PriorityQueue extends DoubleLinkedList{
    public PriorityQueue(){}
    
    public void insertPlater(Player data){
        add(data);
    }
    
    public void updatePlayer(String email, int point){
        updatePlayer(email, point);
    }
    
    public void deletePlayer(String email){
        deletePlayerNode(email);
    }
    
    public void searchPlayer(String email){
        displayPointByEmail(email);
    }
    
    public void getTop(){
        displayTopPlayer();
    }
    
    public void removeTop(){
        if(isEmpty()){
            System.out.println("The List is Empty.... try input some data first.");
        }else{
            removeFirst();
        }
    }
    
}
