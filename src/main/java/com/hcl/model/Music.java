package com.hcl.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Music {
	private String artist;
	
	private String songTitle;
}
