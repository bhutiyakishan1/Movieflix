package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Rating.findByUserIdMovieId", query = "select r from Rating r where r.user.id = :pUserId and r.movie.id = :pMovieId"),
	@NamedQuery(name = "Rating.findAvgByMovieId", query = "select avg(r.value) from Rating r where r.movie.id = :pMovieId"),
	@NamedQuery(name = "Rating.findAll", query = "select r from Rating r where r.user.id = :pUserId" )
})	
public class Rating {
	@Id
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Movie movie;
	
	private int value;
	
	public Rating(){
		id= UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}