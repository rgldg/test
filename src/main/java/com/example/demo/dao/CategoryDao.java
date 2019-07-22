package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category,Long>{

	public List<Category> findAll();
	public Category findById(Integer id);
	
	public void deleteById(Integer id);
}
