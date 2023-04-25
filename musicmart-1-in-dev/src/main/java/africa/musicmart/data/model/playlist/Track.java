package africa.musicmart.data.model.playlist;

import lombok.Data;

import java.util.List;

@Data
public class Track {
    private TrackData trackData;
    private List<Item> items;
}
