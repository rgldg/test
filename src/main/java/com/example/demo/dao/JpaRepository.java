package com.example.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface JpaRepository<Product, ID extends Serializable> extends Repository<Product, ID>{
	public List<Product> findAllById(Iterable<Integer> ids);
	
}
