package com.mdb.api.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mdb.api.model.Person;

public interface PersonRepo extends CrudRepository<Person, UUID> {

	@Query(value = "SELECT * FROM person WHERE LOWER(name) LIKE %:name%", nativeQuery = true)
	public List<Person> getByName (@Param("name") String name);
	
	@Query(value = "SELECT * FROM person WHERE age >= %minAge AND age <= %maxAge", nativeQuery = true)
	public List<Person> getByAge (@Param("minAge") int minAge, @Param("maxAge") int maxAge);
	
	@Query(value = "SELECT * FROM person WHERE sex = :sex", nativeQuery = true)
	public List<Person> getBySex (@Param("sex") String sex);
	
}
