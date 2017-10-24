import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Line> lines = new ArrayList<>();

    public static void main(String[] args) {
        //call readFile
        readFile("inputTest.txt");

        //call shiftAllLines
        shiftAllLines(lines);

        //sort all lines
        sortLines(lines);

        //call print lines
        printLines();
    }

    private static void sortLines(ArrayList<Line> lines) {
        Collections.sort(lines);
    }

    public static void shiftAllLines(ArrayList<Line> lines) {
        for (Line line : lines) {
            line.shiftLine();
        }
    }

    public static void readFile(String filename) {
        File file = new File(filename);

        try {

            Scanner sc = new Scanner(file);

            //loop through the file, line by line
            while (sc.hasNextLine()) {
                //string of new line
                String newLine = sc.nextLine();

                //linked list for new line
                Line line = new Line();

                //loop through new line, adding it word by word
                Scanner scanner = new Scanner(newLine);
                while(scanner.hasNext()){
                    line.addWord(scanner.next());
                }
                lines.add(line);
                scanner.close();

            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printLines(){
        printToConsole();
        printToFile("outputTest.txt");
    }

    private static void printToConsole(){
        for (Line line : lines) {
            System.out.println(line.toString());
        }
    }

    private static void printToFile(String filename){
        try {
            PrintWriter pw = new PrintWriter(filename);
            for (Line line : lines){
                pw.println(line.toString());
            }
            pw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
