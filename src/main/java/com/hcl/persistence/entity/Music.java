package com.hcl.persistence.entity;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Music4u")
public class Music {
	@Id
	private MusicId musicId;

	public Music() {
		
	}

	public Music(MusicId musicId) {
		this.musicId = musicId;
	}

	@DynamoDBHashKey(attributeName = "Artist")
	public String getArtist() {
		return musicId.getArtist();
	}

	public void setArtist(String artist) {
		if(musicId == null)
			musicId = new MusicId();
		
		musicId.setArtist(artist);
	}

	@DynamoDBRangeKey(attributeName = "SongTitle")
	public String getSongTitle() {
		return musicId.getSongTitle();
	}

	public void setSongTitle(String songTitle) {
		if(musicId == null)
			musicId = new MusicId();
		
		musicId.setSongTitle(songTitle);
	}
}