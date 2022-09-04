package com.mdb.api.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.MovieRatingRepo;
import com.mdb.api.model.MovieRating;

@Controller
@RequestMapping("/movieRating")
public class MovieRatingControler {

	@Autowired
	private MovieRatingRepo movieRatingRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllMovieRating () {
		Map<String, Object> msg = new HashMap<>();
		msg.put("size", movieRatingRepo.count());
		msg.put("data", movieRatingRepo.findAll());
		return ResponseEntity.ok(msg);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addMovieRating (MovieRating movieRating) {
		Map<String, Object> msg = new HashMap<>();
		movieRating.setTime(new Timestamp(System.currentTimeMillis()));
		MovieRating added = movieRatingRepo.save(movieRating);
		msg.put("data", added);
		return ResponseEntity.ok(msg);
	}
	
}
