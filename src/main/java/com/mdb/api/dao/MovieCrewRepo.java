package com.mdb.api.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdb.api.model.MovieCrew;

public interface MovieCrewRepo extends CrudRepository<MovieCrew, UUID> {

	@Query(value = "SELECT * FROM movie_crew WHERE LOWER(name) LIKE %:name%", nativeQuery = true)
	public List<MovieCrew> getByName (@Param("name") String name);
	
}
