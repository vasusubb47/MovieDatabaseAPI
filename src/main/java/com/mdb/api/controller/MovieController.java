package com.mdb.api.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.MovieRepo;
import com.mdb.api.model.Movie;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllMovies () {
		Map<String, Object> msg = new HashMap<>();
		msg.put("size", movieRepo.count());
		msg.put("data", movieRepo.findAll());
		return ResponseEntity.ok(msg);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addMovie (Movie movie, String release) {
		Map<String, Object> msg = new HashMap<>();
		Timestamp ts = Timestamp.valueOf(release);
		System.out.println("ts : " + ts);
		movie.setReleaseTime(ts);
		Movie added = movieRepo.save(movie);
		msg.put("added", added);
		return ResponseEntity.ok(msg);
	}
	
}
