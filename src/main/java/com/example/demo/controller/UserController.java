package com.example.demo.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@Controller
@RequestMapping("/*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/*
	 * 前往注册
	 */
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	/*
	 * 执行注册 成功跳转登录页面 否则回调注册页面
	 */
	@RequestMapping("/doregister")
	public String register(HttpServletRequest request,User user) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		String payword=request.getParameter("payword");
		String payword2=request.getParameter("payword2");
		String tel=request.getParameter("tel");
		String realname=request.getParameter("realname");
		String address=request.getParameter("address");
		String sex=request.getParameter("sex");
		if (password.equals(password2)&&payword.equals(payword2)) {
			if (registerUser(username)==true) {
				User user1=new User();
				user1.setUsername(username);
				user1.setPassword(password);
				user1.setPayword(payword);
				user1.setTel(tel);
				user1.setRealname(realname);
				user1.setAddress(address);
				user1.setSex(sex);
				userService.save(user1);
				return "login";
			}else {
				return "register";
			}
		}else {
			return "register";
		}
	}
	
	public Boolean registerUser(String username) {
		Boolean a=true;
		if(userService.findByName(username).isEmpty()) {
			return a;
		}else {
			return false;
		}
	}
	
	/*
	 * 前往登录页面
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	/*
	 * 执行登录
	 */
	@RequestMapping("dologin")
	public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=userService.FindNameAndPsw(username, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
            response.sendRedirect("/");
//			str="index";
		}
	}
	
	/*
	 * 退出登录
	 */
    @RequestMapping("logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("/");
    }
	
	
	/*
	 * 用户信息修改
	 */
	@RequestMapping("toUserEidt")//action
	public String toUserEidt(Map<String, Object> map,Integer id){		
		User user=userService.findById(id);
		map.put("user", user);
		return "useredit";//跳转页面
	}
	
	@RequestMapping("douserupdate")
	public String update(HttpServletRequest request,User user,Integer id) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String payword=request.getParameter("payword");
		String tel=request.getParameter("tel");
		String realname=request.getParameter("realname");
		String address=request.getParameter("address");
		String sex=request.getParameter("sex");
		User user1=userService.findById(id);
		user1.setUsername(username);
		user1.setPassword(password);
		user1.setPayword(payword);
		user1.setTel(tel);
		user1.setRealname(realname);
		user1.setAddress(address);
		user1.setSex(sex);
		userService.edit(user1);
		return "redirect:/";
	}
}
