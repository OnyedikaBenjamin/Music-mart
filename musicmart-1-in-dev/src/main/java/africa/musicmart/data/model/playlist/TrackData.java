package africa.musicmart.data.model.playlist;

import lombok.Data;

@Data
public class TrackData {
    private String href;
    private int limit;
    private String next;
    private int offset;
    private String previous;
    private int total;
}
