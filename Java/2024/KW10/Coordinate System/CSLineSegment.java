

public class CSLineSegment {

    private static int count = 0;
    private int id;
    private CSPoint start;
    private CSPoint end;

    public CSLineSegment(CSPoint start, CSPoint end) {
        this.id = count++;
        this.start = start;
        this.end = end;
    }

    public CSPoint lineStart(){
        return start;
    }

    public CSPoint lineEnd(){
        return end;
    }

    public int getId() {
        return id;}

    public void setLineStart(CSPoint start) {
        this.start = start;
    }

    public void setLineEnd(CSPoint end) {
        this.end = end;
    }
}