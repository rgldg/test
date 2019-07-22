package com.example.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductRec;
@Repository
public interface ProductRecDao extends JpaRepository<ProductRec,Long>{
	public ProductRec findByProductid(Integer id);
	public List<ProductRec> findAll();
}
