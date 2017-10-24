import java.util.LinkedList;

public class Line implements Comparable<Line> {
    LinkedList<String> line = new LinkedList<>();

    //add a work to the end of the linked list
    public void addWord(String word){
        line.add(word);
    }
    //shift the first word to the back
    public void shiftLine(){
        String firstWord = line.poll();
        line.add(firstWord);
    }

    @Override
    public String toString() {
        String result = "";
        LinkedList<String> tempLine = new LinkedList<String>(line);
        result += tempLine.pop();
        while(tempLine.size() > 0){
            result += " " + tempLine.pop();
        }
        return result;
    }

    @Override
    public int compareTo(Line o) {
        return this.toString().compareTo(o.toString());
    }
}
