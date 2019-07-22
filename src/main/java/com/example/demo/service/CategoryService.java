package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.CategoryDao;
import com.example.demo.entity.Category;


@Service
public class CategoryService {

		@Autowired
		CategoryDao categoryDao;
		
		public void save(Category category1) {
			categoryDao.save(category1);
		}
		public List<Category> findAll(){
			return categoryDao.findAll();
		}
		
		public Category findById(Integer id) {
			return categoryDao.findById(id);
		}
		
		public void delete(Integer id) {
			categoryDao.deleteById(id);
		}
		public void edit(Category category2) {
			categoryDao.save(category2);
		}
}
