package io.egen.app.service;

import io.egen.app.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();

	public User findOne(String usrId);

	public User create(User usr);

	public User update(String empid, User emp);

	public void remove(String usrId);

}
