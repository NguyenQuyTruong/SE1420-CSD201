
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nguyen Chi Cuong
 */
public class FileCsv {

    public void readDataFormFileCsv(String path, DoublyLinkedList dll) throws FileNotFoundException, IOException {

        BufferedReader read = new BufferedReader(new FileReader(path));
        String data;
        while ((data = read.readLine()) != null) {
            try {
                String[] array = data.split(",");

            dll.add(array[0], Long.parseLong(array[1].trim()));
            } catch (Exception e) {
            }
            
        }
    }

    public void write(String path, DoublyLinkedList dll) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.append("Email," + " Point" + "\n");
        DoublyLinkedList.Node tmp = dll.header;
        while (tmp != dll.trailer) {
            fileWriter.append(tmp.email + ", " + tmp.point + "\n");
            tmp = tmp.right;
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
