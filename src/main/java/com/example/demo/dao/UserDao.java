package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;
@Repository
public interface UserDao extends JpaRepository<User,Long> {
	public User findByUsernameAndPassword(String username,String password);
	public List<User> findByUsername(String username);
	public List<User> findAll();
	public void deleteById(Integer id);
	public User findById(Integer id);
}
	
	
