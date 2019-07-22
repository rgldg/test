package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product_rec")//推荐表
public class ProductRec {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
//	@OneToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	
	private Integer productid;
	private String showtext;//商品介绍
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getProduct() {
		return productid;
	}
	public void setProduct(Integer productid) {
		this.productid=productid;
	}
	public String getShowText() {
		return showtext;
	}
	public void setShowText(String showtext) {
		this.showtext=showtext;
	}
	
}
