package com.mdb.api.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.PersonRatingRepo;
import com.mdb.api.model.PersonRating;

@Controller
@RequestMapping("/personRating")
public class PersonRatingControler {

	@Autowired
	private PersonRatingRepo personRatingRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllMovieRating () {
		Map<String, Object> msg = new HashMap<>();
		msg.put("size", personRatingRepo.count());
		msg.put("data", personRatingRepo.findAll());
		return ResponseEntity.ok(msg);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addMovieRating (PersonRating personRating) {
		Map<String, Object> msg = new HashMap<>();
		personRating.setTime(new Timestamp(System.currentTimeMillis()));
		PersonRating added = personRatingRepo.save(personRating);
		msg.put("data", added);
		return ResponseEntity.ok(msg);
	}
	
}
