package africa.musicmart.services.impl;

import africa.musicmart.data.dto.request.PlaylistRequest;
import africa.musicmart.data.dto.response.PlaylistResponse;
import africa.musicmart.data.dto.response.TokenResponse;
import africa.musicmart.services.PlaylistService;
import africa.musicmart.utils.SpotifyClient;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class PlaylistServiceImpl implements PlaylistService {
    private final SpotifyClient spotifyClient;


    @Override
    public PlaylistResponse createPlaylist(PlaylistRequest playlistRequest) throws IOException {

        TokenResponse tokenResponse = spotifyClient.getAccessToken();
        String accessToken = tokenResponse.getAccess_token();
        log.info("Access Token" + accessToken);

//        URL url = new URL("https://api.spotify.com/v1/users/"+playlistRequest.getUserId()+"/playlists");
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Authorization", "Bearer " + accessToken);
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setDoOutput(true);
//
//        String postData = "{\"name\":\"" + playlistRequest.getName() + "\",\"public\":true" + "\"description\":\"" + playlistRequest.getDescription() + "}";
//        con.getOutputStream().write(postData.getBytes("UTF-8"));
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();

//        String responseBody = response.toString();
//        log.info(responseBody);
////        Gson gson = new Gson();
////        return gson.fromJson(responseBody, PlaylistResponse.class);
//        return null;

        OkHttpClient okHttpClient = new OkHttpClient();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("userId", playlistRequest.getUserId());
            jsonObject.put("name", playlistRequest.getName());
            jsonObject.put("isPublic", playlistRequest.isPublic());
            jsonObject.put("isCollaborative", playlistRequest.isCollaborative());
            jsonObject.put("description", playlistRequest.getDescription());

        }catch (JSONException ex){
            log.error(ex.getMessage());
        }
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, jsonObject.toString());
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/users/"+playlistRequest.getUserId()+"/playlists")
                .post(requestBody)
                .addHeader("Authorization", "Bearer " +accessToken)
                .addHeader("Content-Type", "application/json")
                .addHeader("Host", "api.spotify.com")
                .build();

        try (ResponseBody response = okHttpClient.newCall(request).execute().body()){
            Gson gson = new Gson();
            log.info(response.string());
//            PlaylistResponse playlistResponse = gson.fromJson(response.string(), PlaylistResponse.class);
//            if (playlistResponse.getName() == null) throw new RuntimeException("Invalid account");
//            return  playlistResponse;
        }
        return null;
    }
}
