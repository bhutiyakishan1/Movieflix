package io.egen.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.app.entity.User;
import io.egen.app.exception.EntityAlreadyExistException;
import io.egen.app.exception.EntityNotFoundException;
import io.egen.app.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String empId) {
		User usr = repository.findOne(empId);
		if (usr == null) {
			throw new EntityNotFoundException("User not found");
		}
		return usr;
	}

	@Transactional
	@Override
	public User create(User usr) {
		User existing = repository.findByEmail(usr.getEmail());
		if (existing != null) {
			throw new EntityAlreadyExistException("User already exists with this email");
		}
		return repository.create(usr);
	}

	@Transactional
	@Override
	public User update(String usrId, User usr) {
		User existing = repository.findOne(usrId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		return repository.update(usr);
	}

	@Transactional
	@Override
	public void remove(String usrId) {
		User existing = repository.findOne(usrId);
		if (existing == null) {
			throw new EntityNotFoundException("User not found");
		}
		repository.delete(existing);
	}


}