package Ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KHAM
 */
public class Main {

    /**
     * Main method
     *
     * @param args
     * @throws MalformedURLException
     * @throws IOException
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        MyQueue mq = new MyQueue();
        int i = 0;
        String oldFileName = null;
        String newFileName = null;
        String email = "";
        String urlInput = "";
        int point = 0;
        int choice = 0;
        if (args[0].equals("-h")) {
            System.out.println("Exercise 1");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucuture into csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n");
            System.out.print("java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
            System.out.print("java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
            return;
        }

        for (i = 0; i < args.length; i++) {

            if (args[i].equals("-r")) {
                oldFileName = args[i + 1];
            }
            if (args[i].equals("-s")) {
                newFileName = args[i + 1];
            }
            if (args[i].equals("-a")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 1;
            }
            if (args[i].equals("-d")) {
                email = args[i + 1];
                choice = 2;
            }
            if (args[i].equals("-u")) {
                email = args[i + 1];
                point = Integer.parseInt(args[i + 2]);
                choice = 3;
            }
            if (args[i].equals("-dt")) {
                choice = 4;
            }
            if (args[i].equals("-g")) {
                email = args[i + 1];
                choice = 5;
            }
            if (args[i].equals("-t")) {
                choice = 6;
            }
            if (args[i].equals("LAB1.jar") && args[i+1].equals("2")) {
                urlInput = args[i+2];
                newFileName = args[i+3];
                choice = 7;
            }
        }

        switch (choice) {
            case 0: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newFileName);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNextLine()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                break;
            }
            case 1: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newFileName);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    Entry e = new Entry(point, email);
                    mq.enqueue(e);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 2: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newFileName);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.delete(email);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 3: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newFileName);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.update(email, point);
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 4: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    PrintWriter pw = null;
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        FileWriter fw = new FileWriter(newFileName);
                        BufferedWriter bw = new BufferedWriter(fw);
                        pw = new PrintWriter(bw);
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    mq.dequeue();
                    pw.println("Email ,Point");
                    pw.write(mq.print());
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 5: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    System.out.println("Point: " + mq.search(email).getPoint());
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 6: {
                try {
                    FileReader file = new FileReader(oldFileName);
                    int pointRead = 0;
                    String emailRead = "";
                    try (Scanner inputStream = new Scanner(file)) {
                        inputStream.nextLine();
                        String line;
                        while (inputStream.hasNext()) {
                            line = inputStream.nextLine();
                            String[] results = line.split(", ");
                            pointRead = Integer.parseInt(results[1]);
                            emailRead = results[0];
                            Entry e = new Entry(pointRead, emailRead);
                            mq.enqueue(e);
                        }
                        inputStream.close();
                    }
                    System.out.println("Highest point: " + mq.front().getPoint());
                } catch (IOException e) {
                    System.out.println("Email not found");
                }
                choice = 0;
                break;
            }
            case 7: {
                Ex2Manager ex2 = new Ex2Manager();
                String line = "";
                String content = "";
                URL ur = new URL(urlInput);

                HttpsURLConnection urlc = (HttpsURLConnection) ur.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

                while ((line = br.readLine()) != null) {
                    content += line;
                }
                ex2.inputStack(content);
                System.out.println("Tag, Quantity");
                Collections.sort(ex2.ar, new Comparator<Tag>() {
                    @Override
                    public int compare(Tag o1, Tag o2) {
                        if (o1.getQuantity() < o2.getQuantity()) {
                            return 1;
                        } else if (o1.getQuantity() == o2.getQuantity()) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                });
                for (Tag ar1 : ex2.ar) {
                    System.out.println(ar1.getTagName() + ", " + ar1.getQuantity());
                }
                try {
                    FileWriter fw = new FileWriter(newFileName);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println("Tag, Quantity");
                    for (Tag ar1 : ex2.ar) {
                        pw.print(ar1.getTagName());
                        pw.print(", ");
                        pw.println(ar1.getQuantity());
                    }
                    pw.close();
                } catch (Exception e) {
                    System.err.println("ERROR!");
                }

            }
        }
    }
}
