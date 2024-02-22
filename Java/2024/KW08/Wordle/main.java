import java.io.IOException;

public class main {

    public static void main(String[] args) {

        try {
            textanalyzer.wordleMechanic();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
