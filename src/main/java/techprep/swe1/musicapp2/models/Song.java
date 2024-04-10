package techprep.swe1.musicapp2.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Song {
    private UUID id;
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int duration;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}