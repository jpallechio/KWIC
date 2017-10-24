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
        FileReader reader = new FileReader(filename);
        lines = reader.readFileByLine(lines);
    }

    private static void printLines() {
        printToConsole();
        printToFile("outputTest.txt");
    }

    private static void printToConsole() {
        for (Line line : lines) {
            System.out.println(line.toString());
        }
    }

    private static void printToFile(String filename) {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.printToFile(lines);
    }
}
