import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException{
        DoubleLinkedList dll = new DoubleLinkedList();
        String safeFile = null;
        boolean save = false;
        Main mainStuff = new Main();
        
        try {
            for (int i = 0; i < args.length; i++){
                switch(args[i]){
                    
                }
            }
        } catch (Exception e) {
        }
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
