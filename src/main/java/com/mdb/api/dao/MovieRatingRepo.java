package com.mdb.api.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.mdb.api.model.MovieRating;

public interface MovieRatingRepo extends CrudRepository<MovieRating, UUID> {

}
