package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User FindNameAndPsw(String username,String password) {
		return userDao.findByUsernameAndPassword(username, password);
	}
	public void save(User user1) {
		userDao.save(user1);
	}
	public List<User> findByName(String username){
		return userDao.findByUsername(username);
	}
	public List<User> findAll(){
		return userDao.findAll();
	}
	public void delete(Integer id) {
		userDao.deleteById(id);
	}
	public User findById(Integer id) {
		return userDao.findById(id);
	}
	public void edit(User user2) {
		userDao.save(user2);
	}
}
