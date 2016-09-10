package io.egen.app.entity;

import java.util.UUID;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m FROM Movie m WHERE m.title=:pTitle ORDER BY m.year DESC") ,
	@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByType", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findByGenre", query = "SELECT m from Movie m WHERE m.genre = :pGenre ORDER BY m.title ASC"),
	@NamedQuery(name = "Movie.findAllSortByYear", query = "SELECT m FROM Movie m ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByYear", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findByYearSortByYear", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.year DESC"),
	@NamedQuery(name = "Movie.findAllSortByRating", query = "SELECT m FROM Movie m ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByRating", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findByYearSortByRating", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbRating DESC"),
	@NamedQuery(name = "Movie.findAllSortByVotes", query = "SELECT m FROM Movie m ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findByTypeSortByVotes", query = "SELECT m FROM Movie m WHERE m.type=:pType ORDER BY m.imdbVotes DESC"),
	@NamedQuery(name = "Movie.findByYearSortByVotes", query = "SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.imdbVotes DESC"),
	
})	

public class Movie {

	@Id
	private String id;
	
	@Column(unique= true)
	private String title;
	private String year;
	private String rated;
	private String released;
	private String runtime;
	private String genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private String Metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String type;
	private String comments;
	private String ratings;
	
	public Movie(){
		id= UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		Actors = actors;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		Plot = plot;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAwards() {
		return Awards;
	}

	public void setAwards(String awards) {
		Awards = awards;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getMetascore() {
		return Metascore;
	}

	public void setMetascore(String metascore) {
		Metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	
}
	
	