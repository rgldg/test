package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	//管理员登录
	public Admin findAnameAndPsw(String username,String password) {
		return adminDao.findByUsernameAndPassword(username, password);
	}
	
	//管理员添加
	public void save(Admin admin1) {
		adminDao.save(admin1);
	}
	
	//管理员名查找
	public List<Admin> findByAdminName(String username){
		return adminDao.findByUsername(username);
	}
	
	//管理员权限查找
	public List<Admin> findByPer(String permission){
		return adminDao.findByPermission(permission);
	}
	
}
