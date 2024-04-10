package techprep.swe1.musicapp2.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Playlist {
    private UUID id;
    private String name;
    private UUID userId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}