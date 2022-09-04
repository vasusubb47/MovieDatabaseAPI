package com.mdb.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mdb.api.dao.PersonRepo;
import com.mdb.api.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepo personRepo;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getAllPerson () {
		Map<String, Object> msg = new HashMap<>();
		msg.put("size", personRepo.count());
		msg.put("data", personRepo.findAll());
		return ResponseEntity.ok(msg);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addPerson (Person person) {
		Map<String, Object> msg = new HashMap<>();
		Person added = personRepo.save(person);
		msg.put("data", added);
		return ResponseEntity.ok(msg);
	}
	
}
