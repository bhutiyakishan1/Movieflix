package io.egen.app.repository;

import java.util.List;

import io.egen.app.entity.Movie;
import io.egen.app.entity.Rating;

public interface RatingRepository {
	Rating createRating(Rating rating);
	List<Rating> getComments(Movie movie);
	double updateAvgRating(Rating rating);

}