package techprep.swe1.musicapp2.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class PlaylistSong {
    private int id;
    private UUID playlistId;
    private UUID songId;
    private Timestamp addedAt;
}

