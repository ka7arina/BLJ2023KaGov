import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuoteGetter {
    public static void getQuote() {
        try {
            // the url that you want to get content from
            URL url = new URL("https://zenquotes.io/api/random/");

            // opening the connection with the server
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // get method ???
            connection.setRequestMethod("GET");

            // response code (???)
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // read the url content if the connection is successful
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print out answer
                System.out.println("Response Content: " + response.toString());
            } else {
                System.out.println("GET Request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[{\n" +
                "\t\"q\": \"Lack of emotion causes lack of progress and lack of motivation.\",\n" +
                "\t\"a\": \"Tony Robbins\",\n" +
                "\t\"i\": \"https://zenquotes.io/img/tony-robbins.jpg\",\n" +
                "\t\"c\": \"63\"";
    }

}
