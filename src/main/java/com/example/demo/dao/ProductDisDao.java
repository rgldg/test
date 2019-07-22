package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductDis;
@Repository
public interface ProductDisDao extends JpaRepository<ProductDis,Long>{
	public ProductDis findByProductid(Integer id);
	public List<ProductDis> findAll();
	public ProductDis findById(Integer id);
}
