package com.mdb.api.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdb.api.model.Movie;

public interface MovieRepo extends CrudRepository<Movie, UUID> {
	
	@Query(value = "SELECT * FROM movie WHERE LOWER(name) LIKE %:name%", nativeQuery = true)
	public List<Movie> getByName (@Param("name") String name);

}
