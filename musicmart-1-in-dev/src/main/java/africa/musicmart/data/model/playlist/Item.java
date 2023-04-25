package africa.musicmart.data.model.playlist;

import lombok.Data;

@Data
public class Item {
    private String addedAt;
    private AddedBy addedBy;
    private boolean isLocal;
    private ItemTrack track;
}
