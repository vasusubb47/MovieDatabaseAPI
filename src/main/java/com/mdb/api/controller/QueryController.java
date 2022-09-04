package com.mdb.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.MovieCrewRepo;
import com.mdb.api.dao.MovieRatingRepo;
import com.mdb.api.dao.MovieRepo;
import com.mdb.api.dao.PersonRatingRepo;
import com.mdb.api.dao.PersonRepo;
import com.mdb.api.model.Movie;
import com.mdb.api.model.MovieCrew;
import com.mdb.api.model.Person;

@Controller
public class QueryController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private MovieCrewRepo movieCrewRepo;
	
	@Autowired
	private MovieRatingRepo movieRatingRepo;
	
	@Autowired
	private PersonRatingRepo personRatingRepo;
	
	@RequestMapping (value = "/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getDataByName (@PathVariable(name = "name") String name) {
		System.out.println("Name : " + name);
		Map<String, Object> msg = new HashMap<>();
		
		List<Movie> movieList = movieRepo.getByName(name);
		List<Person> personList = personRepo.getByName(name);
		List<MovieCrew> movieCrewList = movieCrewRepo.getByName(name);
		
		if (movieList.size() > 0) {
			msg.put("movies", movieList);
		}
		if (personList.size() > 0) {
			msg.put("people", personList);
		}
		if (movieCrewList.size() > 0) {
			msg.put("movieCrews", movieCrewList);
		}


		
		return ResponseEntity.ok(msg);
	}
	
}
