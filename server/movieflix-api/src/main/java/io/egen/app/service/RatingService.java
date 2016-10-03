package io.egen.app.service;

import java.util.List;

import io.egen.app.entity.Movie;
import io.egen.app.entity.Rating;

public interface RatingService {
	Rating createRating(Rating rating);
	List<Rating> getComments(Movie movie);
	void updateAvgRating(Rating rating);
}
