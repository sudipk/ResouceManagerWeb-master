package edu.sjsu.courseapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sjsu.courseapp.dao.UserDAO;
import edu.sjsu.courseapp.dao.jdbc.UserDaoJdbcImpl;
import edu.sjsu.courseapp.domain.User;


@Transactional(rollbackFor={java.io.IOException.class},noRollbackFor = ArithmeticException.class)
@Service
public class UserServiceImpl implements UserService {
	@Qualifier("UserDaoJdbcImpl")
	@Autowired
	private UserDAO  userDao=new UserDaoJdbcImpl();

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}


	@Override
	public List<User> getUserList() {
		List<User> users = userDao.getUserallList();
		return users;
	}


	@Override
	public List<User> getUserByName(String name) {
		List<User>userList=(List<User>) userDao.findUserByName(name);
		return userList;
	}
	
	@Override
	public void insertUser(List<User> user) {
		 userDao.insertUser(user);
	}


	@Override
	public String getUserbyId(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserNameById(id);
	}

}
