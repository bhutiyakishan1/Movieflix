package io.egen.app.repository;

import io.egen.app.entity.User;

import java.util.List;

public interface UserRepository {


	public List<User> findAll();

	public User findOne(String usrId);

	public User findByEmail(String email);

	public User create(User usr);

	public User update(User usr);

	public void delete(User existing);


	
	

}
