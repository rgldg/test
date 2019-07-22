package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product_dis")//打折表
public class ProductDis {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
//	@OneToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer productid;
	private Integer discount;//折扣
	private float price;//价格
	
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
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount=discount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price=(float)Math.round(price*100)/100;
	}
}
