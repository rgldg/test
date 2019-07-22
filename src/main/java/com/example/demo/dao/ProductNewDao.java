package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductNew;
@Repository
public interface ProductNewDao extends JpaRepository<ProductNew,Long>{
	public ProductNew findByProductid(Integer id);
//	@Query(value="select product_id from ProductNew")
//	public List<Integer> findByProduct_id(Integer id);
	public List<ProductNew> findAll();
//	public List<ProductNew> findAllByProductid();
}
