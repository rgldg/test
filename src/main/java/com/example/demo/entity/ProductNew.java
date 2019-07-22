package com.example.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="product_new")//最新表
//@NamedNativeQuery(name="queryProductNewById",
//				query="select id,product_id from product_new where id=?",
//				resultSetMapping="productNew")
//@SqlResultSetMapping(name="productNew",entities=@EntityResult(entityClass=ProductNew.class))
public class ProductNew {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
//	@NotFound(action=NotFoundAction.IGNORE)
//	@OneToOne
//	@Column(name="product_id")
	private Integer productid;	
	public Timestamp systime;
	
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
	public Timestamp getSystime() {
		return systime;
	}
	public void setSystime(Timestamp systime) {
		this.systime=systime;
	}
	public ProductNew() {
		
	}

}
