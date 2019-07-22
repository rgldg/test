package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductDisDao;
import com.example.demo.dao.ProductNewDao;
import com.example.demo.dao.ProductRecDao;
import com.example.demo.dao.ShopCartDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDis;
import com.example.demo.entity.ProductNew;
import com.example.demo.entity.ProductRec;
import com.example.demo.entity.ShopCart;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	@Autowired
	ProductDisDao productDisDao;
	@Autowired
	ProductNewDao productNewDao;
	@Autowired
	ProductRecDao productRecDao;
	@Autowired 
	ShopCartDao shopCartDao;
	public void save(Product product1) {
		productDao.save(product1);
	}
	public void saveDis(ProductDis productDis1) {
		productDisDao.save(productDis1);
	}
	public void saveNew(ProductNew productNewDao1) {
		productNewDao.save(productNewDao1);
	}
	public void saveRec(ProductRec productRecDao1) {
		productRecDao.save(productRecDao1);
	}
	public void saveShop(ShopCart shopCart) {
		shopCartDao.save(shopCart);
	}
	public List<Product> findAll(){
		return productDao.findAll();
	}
	public List<ShopCart> findShopAll(){
		return shopCartDao.findAll();
	}
	public void delete(Integer id) {
		productDao.deleteById(id);
	}
	
	public Product findById(Integer id){
		return productDao.findById(id);
	}
	public List<ShopCart> findByuserid(Integer user) {
		return shopCartDao.findByuserid(user);
	}
	public void edit(Product product2) {
		productDao.save(product2);
	}
	
	public ProductNew findByProductId(Integer id){
		return productNewDao.findByProductid(id);
	}
	
	public ProductRec findByIdRec(Integer id){
		return productRecDao.findByProductid(id);
	}
	public ProductDis findByIdDis(Integer id){
		return productDisDao.findByProductid(id);
	}
	
	//查找最新商品
//	public List<Product> findTopByIdAndProduct_id(){
//		return productDao.findTopByIdAndProduct_id();
//	}
	

	public List<Product> findAllById(Iterable<Integer> ids){
		return productDao.findAllById(ids);
	}
	
}
