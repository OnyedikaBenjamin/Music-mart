package africa.musicmart.services;

import africa.musicmart.data.dto.request.PlaylistRequest;
import africa.musicmart.data.dto.response.PlaylistResponse;

import java.io.IOException;

public interface PlaylistService {

    PlaylistResponse createPlaylist(PlaylistRequest request) throws IOException;
}
