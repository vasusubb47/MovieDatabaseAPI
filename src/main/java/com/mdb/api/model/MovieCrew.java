package com.mdb.api.model;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class MovieCrew {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid" , strategy = "uuid2")
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mid", referencedColumnName = "id")
	private Movie movie;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pid", referencedColumnName = "id")
	private Person person;
	
	private String character;
	private String name;
	
	public MovieCrew() {
		super();
	}

	public MovieCrew(UUID id, Movie movie, Person person, String character, String name) {
		super();
		this.id = id;
		this.movie = movie;
		this.person = person;
		this.character = character;
		this.name = name;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(character, id, movie, name, person);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieCrew other = (MovieCrew) obj;
		return Objects.equals(character, other.character) && Objects.equals(id, other.id)
				&& Objects.equals(movie, other.movie) && Objects.equals(name, other.name)
				&& Objects.equals(person, other.person);
	}

	@Override
	public String toString() {
		return "MovieCrew [id=" + id + ", movie=" + movie + ", person=" + person + ", character=" + character + ", name="
				+ name + "]";
	}
	
}
