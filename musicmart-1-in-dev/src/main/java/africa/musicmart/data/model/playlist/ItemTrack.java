package africa.musicmart.data.model.playlist;

import lombok.Data;

@Data
public class ItemTrack {
    private String name;
    private Integer popularity;
    private String previewUrl;
    private Integer trackNumber;
    private String type;
    private String uri;
    private boolean isLocal;
    private String href;
    private String id;
    private boolean isPlayable;
    private Integer discNumber;
    private Integer durationMs;
    private boolean isExplicit;

}
