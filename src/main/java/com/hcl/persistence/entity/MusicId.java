package com.hcl.persistence.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

public class MusicId {
    private String artist;
    
    private String songTitle;

    public MusicId() {
    	
    }
    
    public MusicId(String artist, String songTitle) {
        this.artist = artist;
        this.songTitle = songTitle;
    }

    @DynamoDBHashKey(attributeName = "Artist")
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @DynamoDBRangeKey(attributeName = "SongTitle")
    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
}