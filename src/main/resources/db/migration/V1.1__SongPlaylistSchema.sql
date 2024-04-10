-- V1.1__createInitialSchema.sql

-- Create the "User" table
DROP TABLE IF EXISTS "users";
CREATE TABLE "User" (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the "Song" table
CREATE TABLE "Song" (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    album VARCHAR(255),
    genre VARCHAR(255),
    duration INTEGER NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the "Playlist" table
CREATE TABLE "Playlist" (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    user_ID UUID NOT NULL REFERENCES "User"(id),
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the "PlaylistSong" junction table - join table
CREATE TABLE "PlaylistSong" (
    id SERIAL PRIMARY KEY,
    playlist_ID UUID NOT NULL REFERENCES "Playlist"(id),
    song_ID UUID NOT NULL REFERENCES "Song"(id),
    addedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (playlist_ID, song_ID)                     -- Ensure that a song can only be added once to a playlist
);