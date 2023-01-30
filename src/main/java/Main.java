import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        URL url = new URL("https://jsonplaceholder.typicode.com/albums");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        JSONArray jsonArray = new JSONArray(result.toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject album = jsonArray.getJSONObject(i);
            int id = album.getInt("id");
            int userId = album.getInt("userId");
            String title = album.getString("title");

            System.out.println("ID: " + id + " User ID: " + userId + " Title: " + title);
        }
    }
}
