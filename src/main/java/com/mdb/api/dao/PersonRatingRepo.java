package com.mdb.api.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.mdb.api.model.PersonRating;

public interface PersonRatingRepo extends CrudRepository<PersonRating, UUID> {

}
