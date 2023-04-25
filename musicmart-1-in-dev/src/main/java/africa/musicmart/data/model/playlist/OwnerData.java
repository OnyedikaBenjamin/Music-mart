package africa.musicmart.data.model.playlist;

import lombok.Data;

@Data
public class OwnerData {
    private ExternalUrl externalUrl;
    private Follower followers;
    private String href;
    private String id;
    private String type;
    private String uri;
}
