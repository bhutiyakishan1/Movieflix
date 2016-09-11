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
		@NamedQuery(name = "Comment.findByMovieId", query = "select c from Comment c inner join c.movie m where m.id = :pMovieId"),
		@NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
})		
public class Comment {
	@Id
	private String id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Movie movie;
	
	private String value;
	
	public Comment(){
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
