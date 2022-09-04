package com.mdb.api.model;

import java.sql.Timestamp;
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
public class PersonRating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid" , strategy = "uuid2")
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="mcid", referencedColumnName = "id")
	private MovieCrew movieCrew;
	
	private String comment;
	private int rating;
	private Timestamp time;
	
	public PersonRating() {
		super();
	}

	public PersonRating(UUID id, MovieCrew movieCrew, String comment, int rating, Timestamp time) {
		super();
		this.id = id;
		this.movieCrew = movieCrew;
		this.comment = comment;
		this.rating = rating;
		this.time = time;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public MovieCrew getMovieCrew() {
		return movieCrew;
	}

	public void setMovieCrew(MovieCrew movieCrew) {
		this.movieCrew = movieCrew;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment, id, movieCrew, rating, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonRating other = (PersonRating) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(id, other.id)
				&& Objects.equals(movieCrew, other.movieCrew) && rating == other.rating
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "PersonRating [id=" + id + ", movieCrew=" + movieCrew + ", comment=" + comment + ", rating=" + rating
				+ ", time=" + time + "]";
	}
	
}
