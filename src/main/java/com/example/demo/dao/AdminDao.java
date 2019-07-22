package com.example.demo.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer>{
	
	public Admin findByUsernameAndPassword(String username,String password);
	public List<Admin> findByUsername(String username);
	public List<Admin> findByPermission(String permission);//权限查找
	
}
