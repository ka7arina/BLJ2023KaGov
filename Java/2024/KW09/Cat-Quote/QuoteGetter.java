import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class QuoteGetter {
    public static void getQuote() {

        try {
            URL url = new URL("https://zenquotes.io/api/random/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                Scanner userinput = new Scanner(System.in);
                System.out.println("Do you want another quote? [y/n]");

                String anotherQuote = userinput.nextLine();

                if (anotherQuote.equals("y")) {

                    // New code for parsing and printing the quote and author
                    String jsonResponse = response.toString();
                    int quoteStart = jsonResponse.indexOf("\"q\":\"") + 5;
                    int quoteEnd = jsonResponse.indexOf("\"", quoteStart);
                    String quote = jsonResponse.substring(quoteStart, quoteEnd);
                    int authorStart = jsonResponse.indexOf("\"a\":\"", quoteEnd) + 5;
                    int authorEnd = jsonResponse.indexOf("\"", authorStart);
                    String author = jsonResponse.substring(authorStart, authorEnd);
                    System.out.println("\"" + quote + "\" - " + author);
                }
            } else {
                System.out.println("GET Request failed");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
