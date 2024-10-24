
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    // Single method to retrieve value from JSON
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        // Fetch JSON response from the API
        String jsonResponse = getJsonFromApi(urlString);

        // Extract the attribute from the JSON
        return extractAttributeFromJson(jsonResponse, attributeName);
    }

    // Method to send HTTP request and get JSON response
    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    // Method to parse JSON and extract the desired attribute
    private String extractAttributeFromJson(String json, String attributeName)
            throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found.");
            }
            return value.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.");
        }
    }
}
