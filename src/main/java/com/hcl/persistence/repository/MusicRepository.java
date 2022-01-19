package com.hcl.persistence.repository;

import java.util.Collection;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.hcl.persistence.entity.Music;
import com.hcl.persistence.entity.MusicId;

@EnableScan
public interface MusicRepository extends CrudRepository<Music, MusicId>{
	public Collection<Music> findBySongTitleContaining(String songTitle);
}
