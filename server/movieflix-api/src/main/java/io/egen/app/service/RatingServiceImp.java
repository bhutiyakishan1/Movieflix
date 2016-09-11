package io.egen.app.service;

import java.util.List;
import java.util.Map;

import io.egen.app.entity.Movie;
import io.egen.app.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.Rating;
import io.egen.app.exception.EntityAlreadyExistException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.RatingRepository;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository repository;
	@Autowired
	UserService userService;   
	@Autowired
	MovieService movieService;  
	
	
	@Override
	public double findByArguments(Map<String, String> params) {
		return repository.findByArguments(params);
	}

	@Override
	public Rating findById(String id) {
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Rating create(Map<String, String> params,Rating rating) {
		List<Rating> existing = repository.findByUserIdMovieId(params.get("userId"),params.get("movieId"));
		if (existing.size() != 0) {
			throw new EntityAlreadyExistException("Rating already created: for user:" + params.get("userId") + " movie: "+params.get("movieId"));
		}
		Movie movie = movieService.findById(params.get("movieId"));
		User user = userService.findOne(params.get("userId"));
		rating.setUser(user);
		rating.setMovie(movie);
		return repository.create(rating);
	}

	@Override
	@Transactional
	public Rating update(String id, Rating emp) {
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Rating existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Rating with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}