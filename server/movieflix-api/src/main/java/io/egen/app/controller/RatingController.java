package io.egen.app.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.app.entity.Movie;
import io.egen.app.entity.Rating;
import io.egen.app.service.MovieService;
import io.egen.app.service.RatingService;


@RestController
@RequestMapping(path = "ratings")
public class RatingController {
	@Autowired
	RatingService ratingservice;

	@Autowired
MovieService movieservice;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Rating createRating(@RequestBody Rating rating) {
		return ratingservice.createRating(rating);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "getComments/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Rating> getComments(@PathVariable("movieId") String movieId){
		Movie movie  =  movieservice.findById(movieId);
		return ratingservice.getComments(movie);
	}
	

}