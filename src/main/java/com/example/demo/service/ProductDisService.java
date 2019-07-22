package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductDisDao;
import com.example.demo.entity.ProductDis;

@Service
public class ProductDisService {

	@Autowired
	ProductDisDao productDisDao;
	
	public ProductDis findById(Integer id) {
		return productDisDao.findById(id);
	}
	
	public List<ProductDis> findAll(){
		return productDisDao.findAll();
	}
	
}
