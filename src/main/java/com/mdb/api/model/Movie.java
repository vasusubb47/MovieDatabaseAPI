package com.mdb.api.model;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO , generator = "pg-uuid")
    @GenericGenerator(name = "pg-uuid" , strategy = "uuid2")
	private UUID id;
	private String name;
	private int length;
	private String catagory;
	private Timestamp releaseTime;
	
	public Movie() {
		super();
	}

	public Movie(UUID id, String name, int length, String catagory, Timestamp releaseTime) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.catagory = catagory;
		this.releaseTime = releaseTime;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Timestamp getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(catagory, id, length, name, releaseTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(catagory, other.catagory) && Objects.equals(id, other.id) && length == other.length
				&& Objects.equals(name, other.name) && Objects.equals(releaseTime, other.releaseTime);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", length=" + length + ", catagory=" + catagory + ", releaseTime="
				+ releaseTime + "]";
	}
	
}
