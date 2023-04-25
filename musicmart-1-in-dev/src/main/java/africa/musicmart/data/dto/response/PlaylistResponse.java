package africa.musicmart.data.dto.response;

import africa.musicmart.data.model.playlist.*;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
public class PlaylistResponse{
    private boolean isCollaborative;
    private String description;
    private ExternalUrl externalUrls;
    private Follower followers;
    private String href;
    private String spotifyId;
    private List<Images> images;
    private String name;
    private Owner owner;
    private boolean isPublic;
    private String snapshotId;
    private Track tracks;
    private String type;
}
