package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@Controller
@RequestMapping("/*")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	/*
	 * 跳转到类目添加页面
	 * @return
	 */
	@RequestMapping("categoryadd")
	public String categoryadd() {
		return "categoryadd";
	}

	
	
	@RequestMapping("docategoryadd")
	public String categoryadd(HttpServletRequest request,Category category) {
		String name=request.getParameter("name");
		Category category1=new Category();
		category1.setName(name);
		categoryService.save(category1);
		return "categoryadd";		
	}
	
	@RequestMapping(value= {"toproductadd"})//action
	public String categoryList(HttpSession session){
		List<Category> categoryList=categoryService.findAll();
		session.setAttribute("categoryList",categoryList);
		return "productadd";//跳转页面
	}
	
	
	@RequestMapping("tocategoryshow")
	public String categoryShow(HttpSession session) {		
		List<Category> category=categoryService.findAll();
		session.setAttribute("category", category);
		return "categoryshow";
	}
	
	@Transactional
	@RequestMapping("catedelete")
	public String delete(Integer id) {
		categoryService.delete(id);
		return "redirect:/tocategoryshow";
	}
	
	@Transactional
	@RequestMapping(value= {"tocategoryupdate"})//action
	public String toCategoryupdate(HttpSession session,Map<String, Object> map,Integer id){//,Model model,Map<String, Object> map		
		Category category=categoryService.findById(id);
		map.put("category", category);
//		session.setAttribute("category", category);
		return "categoryupdate";//跳转页面
	}
	
	@RequestMapping("docategoryupdate")
	public String toEdit(HttpServletRequest request,Category category,Integer id) {
		String name=request.getParameter("name");		
		Category category1=categoryService.findById(id);
		category1.setName(name);
		categoryService.edit(category1);
		return "redirect:/tocategoryshow";	
	}
}
