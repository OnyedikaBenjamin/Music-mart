package africa.musicmart.utils;


import africa.musicmart.data.dto.response.TokenResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;


@Service
@Slf4j
public class SpotifyClient {
    @Value("${TOKEN_ENDPOINT}")
    private String TOKEN_ENDPOINT;
    @Value("${CLIENT_ID}")
    private String CLIENT_ID;
    @Value("${CLIENT_SECRET}")
    private String CLIENT_SECRET;

    public TokenResponse getAccessToken() {
        try {
            HttpURLConnection connection = getHttpURLConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuilder response = new StringBuilder();
                String line;
                var reader = new java.io.BufferedReader(new java.io.InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                String responseBody = response.toString();
                Gson gson = new Gson();
                return gson.fromJson(responseBody, TokenResponse.class);
            } else {
                log.error("Authorization request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            log.error("Error getting access token: " + e.getMessage());
        }
        return null;
    }

    private HttpURLConnection getHttpURLConnection() throws IOException {
        String clientCredentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedCredentials = Base64.getEncoder().encodeToString(clientCredentials.getBytes());

        String authHeader = "Basic " + encodedCredentials;

        String data = "grant_type=client_credentials";

        URL url = new URL(TOKEN_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", authHeader);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);
        byte[] postData = data.getBytes();
        connection.getOutputStream().write(postData);
        return connection;
    }
}
