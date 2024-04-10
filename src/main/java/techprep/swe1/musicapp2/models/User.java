package techprep.swe1.musicapp2.models;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class User {
    private UUID id;
    private String username;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

