package com.example.demo.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Product;

@Repository
public interface ProductDao extends com.example.demo.dao.JpaRepository<Product,Long>{
	
//	public List<Product> getProductsList(Integer page,Integer size);
	
	public List<Product> findAll();
	

	public void deleteById(Integer id);
	public Product findById(Integer id);
	

	public List<Product> findAllById(Iterable<Integer> ids);


	public void save(Product product2);


	
	
}
