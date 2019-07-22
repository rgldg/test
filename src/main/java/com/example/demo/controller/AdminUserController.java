package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/*")
public class AdminUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("toadminusershow")
	public String userShow(HttpSession session) {
		List<User> userList=userService.findAll();
		session.setAttribute("userList", userList);
		return "adminusershow";
	}
	
	@Transactional
	@RequestMapping("userdelete")
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/toadminusershow";
	}
	
	@Transactional
	@RequestMapping("toadminuserupdate")//action
	public String toEdit(Map<String, Object> map,Integer id){//,Model model,Map<String, Object> map		
		User user=userService.findById(id);
		map.put("user", user);
		return "adminuserupdate";//跳转页面
	}
	
	@RequestMapping("doadminuserupdate")
	public String update(HttpServletRequest request,User user,Integer id) {
		String username=request.getParameter("username");		
		String tel=request.getParameter("tel");
		String realname=request.getParameter("realname");
		String address=request.getParameter("address");
		String sex=request.getParameter("sex");
		User user1=userService.findById(id);
		user1.setUsername(username);
		user1.setTel(tel);
		user1.setRealname(realname);
		user1.setAddress(address);
		user1.setSex(sex);
		userService.edit(user1);
		return "redirect:/toadminusershow";
	}
}
