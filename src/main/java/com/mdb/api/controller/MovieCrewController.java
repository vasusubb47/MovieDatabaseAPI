package com.mdb.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.MovieCrewRepo;
import com.mdb.api.model.MovieCrew;

@Controller
@RequestMapping("/movieCrew")
public class MovieCrewController {
	
	@Autowired
	private MovieCrewRepo movieCrewRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllMoviesCrews () {
		Map<String, Object> msg = new HashMap<>();
		msg.put("size", movieCrewRepo.count());
		msg.put("data", movieCrewRepo.findAll());
		return ResponseEntity.ok(msg);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addMovieCrew (MovieCrew movieCrew) {
		Map<String, Object> msg = new HashMap<>();
		MovieCrew added = movieCrewRepo.save(movieCrew);
		msg.put("added", added);
		return ResponseEntity.ok(msg);
	}
	
}
