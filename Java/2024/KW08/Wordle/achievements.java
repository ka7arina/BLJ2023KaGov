import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class achievements {
    public static void mechanic() throws IOException {
        String[][] achievement = {
                {"Man", "Sparkes", "msparkes0@springhow.com", "Engineering"}
        };

        File csvFile = new File("C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/achievements.csv");
        FileWriter fileWriter = new FileWriter(csvFile);

        for (String[] data : achievement) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                line.append("\"");
                line.append(data[i].replaceAll("\"","\"\""));
                line.append("\"");
                if (i != data.length - 1) {
                    line.append(',');
                }
            } line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }
}
