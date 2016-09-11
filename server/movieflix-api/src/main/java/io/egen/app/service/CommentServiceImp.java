package io.egen.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.app.entity.Comment;
import io.egen.app.entity.Movie;
import io.egen.app.entity.User;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentRepository repository;
	@Autowired
	UserService userService;
	@Autowired
	MovieService movieService;
	
	@Override
	public List<Comment> findByArguments(Map<String, String> params) {
		return repository.findByArguments(params);
	}

	@Override
	public Comment findById(String id) {
		Comment existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Comment create(Map<String, String> params, Comment comment) {
		Movie movie = movieService.findById(params.get("movieId"));
		User user = userService.findOne(params.get("userId"));
		comment.setUser(user);
		comment.setMovie(movie);
		return repository.create(comment);
	}

	@Override
	@Transactional
	public Comment update(String id, Comment emp) {
		Comment existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		return repository.update(emp);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comment existing = repository.findById(id);
		if (existing == null) {
			throw new EntityNotFoundException("Comment with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
