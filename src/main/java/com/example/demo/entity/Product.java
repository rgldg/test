package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;

@Entity(name="product")//商品表
public class Product {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private Integer id;
		private String name;//商品名称
		private Integer stock;//库存
		private String description;//描述
		private Integer count;//点击计数
		private float price;//商品价格
		private String path;//图片存储路径
		private Integer csid;
//		private Integer categoryId;//类目ID
		@ManyToOne
		@NotFound(action=NotFoundAction.IGNORE)
		private Category category;
//		@Transient		
//		private Integer productNew;//最新
//		@Transient
//		private Integer isRec;//推荐
//		@Transient
//		private Integer isDis;//打折
		
		
		public void setCategoryS(Category category) {
		        this.category = category;
		    }
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id=id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name=name;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock=stock;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description=description;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count=count;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price=(float)Math.round(price*100)/100;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category=category;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path=path;
		}
//		public Integer getIsNew() {
//			return productNew;
//		}
//		public void setIsNew(Integer productNew) {
//			this.productNew=productNew;
//		}
//		public Integer getIsRec() {
//			return isRec;
//		}
//		public void setIsRec(Integer isRec) {
//			this.isRec=isRec;
//		}
//		public Integer getIsDis() {
//			return isDis;
//		}
//		public void setIsDis(Integer isDis) {
//			this.isDis=isDis;
//		}
		public Integer getCsid() {
			return csid;
		}
		public void setCsid(Integer csid) {
			this.csid = csid;
		}
		public Product() {
			
		}
}
