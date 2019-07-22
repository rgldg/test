package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="user_orders")//用户订单表
public class User_Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;//用户订单表id
	private float price;//商品单价
	private Integer amount;//商品数量
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer productid;//商品id
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer ordersid;//管理员订单表id
	@Transient//不持久化
	private float total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price=(float)Math.round(price*100)/100;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount=amount;
	}
	public Integer getProduct() {
		return productid;
	}
	public void setProduct(Integer productid) {
		this.productid=productid;
	}
	public Integer getOrder() {
		return ordersid;
	}
	public void setOrder(Integer ordersid) {
		this.ordersid=ordersid;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = (float)Math.round(total*100)/100;
	}	
	
}
