package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@Controller
@RequestMapping("/*")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	/*
	 * 前往注册
	 */
	@RequestMapping("/adminregister")
	public String register() {
		return "adminregister";
	}

	
	//管理员添加
	@RequestMapping("/doadminregister")
	public String adminregister(HttpServletRequest request,Admin admin) {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String permission=request.getParameter("permission");
		if(password.equals(password2)) {//输入两次密码判断
			if(adminregister(username)==true) {//如果查找管理员不存在
				Admin admin1=new Admin();
				admin1.setUsername(username);
				admin1.setPassword(password);
				admin1.setPermission(permission);
				adminService.save(admin1);
				return "adminlogin";//添加成功，跳转登录
			}else {
				return "adminregister";//添加失败，继续添加
			}
		}else {
			return "adminregister";
		}
	}
	
	//查找是否已存在管理员账号
	public boolean adminregister(String username) {
		Boolean flag=true;
		if(adminService.findByAdminName(username).isEmpty()) {
			return flag;
		}else {
			return false;
		}
	}
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping("/adminlogin")
	public String login() {
		return "adminlogin";
	}
	//管理员登录
	@RequestMapping("/doadminlogin")//action
	public String adminlogin(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Admin admin= adminService.findAnameAndPsw(username, password);
		String str="";
		if (admin!=null) {
			str="success"; 
		}else {
			str="adminlogin";
		}
		return str;
	}
	
}
