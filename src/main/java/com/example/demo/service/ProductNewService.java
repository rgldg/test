package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductNewDao;
import com.example.demo.entity.ProductNew;

@Service
public class ProductNewService {
	@Autowired
	ProductNewDao productNewDao;
	
	public List<ProductNew> findAll(){
		return productNewDao.findAll();
	}
//	public List<ProductNew> findAllByProductid() {
//		return productNewDao.findAllByProductid();	
//	}
	
}
