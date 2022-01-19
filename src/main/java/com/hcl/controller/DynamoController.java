package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Music;
import com.hcl.persistence.repository.MusicRepository;

@RestController
public class DynamoController {
	@Autowired
	private MusicRepository musicRepository;
	
	@PostMapping("/api/v1/add")
	public ResponseEntity<?> add(@RequestBody Music request) {
		com.hcl.persistence.entity.Music entity = new com.hcl.persistence.entity.Music();
		
		entity.setArtist(request.getArtist());
		entity.setSongTitle(request.getSongTitle());
		
		musicRepository.save(entity);
		
		return new ResponseEntity<String>("Saved", HttpStatus.OK);
	}
	
	@PostMapping("/api/v1/findby/title")
	public ResponseEntity<?> findByTitle(@RequestBody Music request) {
		musicRepository.findAll().forEach(m -> {System.out.println(m.getSongTitle());});
		
		int count = musicRepository.findBySongTitleContaining(request.getSongTitle()).size();
		
		return new ResponseEntity<String>("No. of Songs Found: " + count, HttpStatus.OK);
	}
}
