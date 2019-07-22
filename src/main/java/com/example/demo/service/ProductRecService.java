package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRecDao;
import com.example.demo.entity.ProductRec;
@Service
public class ProductRecService {

	@Autowired
	ProductRecDao productRecDao;
	
	public List<ProductRec> findAll(){
		return productRecDao.findAll();
	}
}
