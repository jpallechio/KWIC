import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File file;
    private static Scanner fileScanner;

    public FileReader(String filename) {
        this.file = new File(filename);
    }

    public ArrayList<Line> readFileByLine(ArrayList<Line> lines) {
        try {
            fileScanner = new Scanner(file);

            //read in one line at a time
            while (fileScanner.hasNextLine()) {
                //String of new line
                String newLine = fileScanner.nextLine();

                //linked list for new line
                Line line = new Line();

                //loop through new line, adding it to the line
                Scanner lineReader = new Scanner(newLine);
                while (lineReader.hasNext()) {
                    line.addWord(lineReader.next());
                }

                lines.add(line);
                lineReader.close();
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}
