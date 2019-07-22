package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShopCart;
import java.lang.Integer;
@Repository
public interface ShopCartDao extends JpaRepository<ShopCart,Long>{
	 	List<ShopCart> findByuserid(Integer user);
}
