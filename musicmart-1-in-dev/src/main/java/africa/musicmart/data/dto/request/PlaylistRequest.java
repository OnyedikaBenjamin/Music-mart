package africa.musicmart.data.dto.request;

import africa.musicmart.data.model.Song;
import lombok.Data;

@Data
public class PlaylistRequest {
    private String userId;
    private String name;
    private boolean isPublic = true;
    private boolean isCollaborative = false;
    private String description;
}
