package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="shopcart")//购物车表
public class ShopCart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;//购物车id
	private Integer amount;//数量
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer productid;//商品id
//	@ManyToOne
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer userid;//用户id
	private float total;//总价格
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
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
	public Integer getUser() {
		return userid;
	}
	public void setUser(Integer userid) {
		this.userid=userid;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total=total;
	}
}
