public class CSLineSegment {

    private static int count = 0;
    private int id;
    private CSPoint start;
    private CSPoint end;

    // constructor
    public CSLineSegment(CSPoint start, CSPoint end) {
        this.id = count++;
        this.start = start;
        this.end = end;
    }

    // methods for the lineStart and lineEnd
    public CSPoint lineStart(){
        return start;
    }

    public CSPoint lineEnd(){
        return end;
    }

}