import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class achievements {
    public static void mechanic() throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        String[][] achievement = {
                {dtf.format(now)}
        };

        File csvFile = new File("C:/Projects/BLJ2023KaGov/Java/2024/KW08/Wordle/achievements.csv");

        boolean isNewFile = !csvFile.exists() || csvFile.length() == 0;
        FileWriter fileWriter = new FileWriter(csvFile, true);

        // Write headers if file is new or empty
        if (isNewFile) {
            fileWriter.append("Date,Word,Attempts,TimeInSeconds\n");
        }

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
