package edu.sjsu.courseapp.services;

import java.util.List;

import edu.sjsu.courseapp.domain.User;


public interface UserService {
	public List<User> getUserList();
	public void deleteUser(Integer id);
	public String getUserbyId(int id);
	public List<User> getUserByName(String name);
	void insertUser(List<User> user);
}
