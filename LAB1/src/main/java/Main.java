
import java.io.IOException;

public class Main {

    public static PriorityQueue queue;
    
    public static void main(String[] args) throws IOException{
        String inputFile = "";
        String outputFile = "";
        Main mainStuff = new Main();
        for(int i = 0; i < args.length; i ++){
             try {
                switch(args[i]){
                    case "-r":
                        queue = new PriorityQueue();
                        inputFile = args[i + 1];
                        
                        break;
                    case "-a":
                        break;
                    case "-u":
                        break;
                    case "-dt":
                        break;
                    case "-d":
                        break;
                    case "-g":
                        break;
                }
        }
        catch (Exception e) {
        }
        }  
    }
    
}
