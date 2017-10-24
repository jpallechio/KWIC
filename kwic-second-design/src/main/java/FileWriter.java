
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWriter {
    private String filename;

    public FileWriter(String filename) {
        this.filename = filename;
    }

    public void printToFile(ArrayList<Line> lines) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            for (Line line : lines) {
                pw.println(line.toString());
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
