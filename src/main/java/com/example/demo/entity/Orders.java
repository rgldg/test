package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name="orders")//管理员订单表
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private Integer status;//订单状态
	private Date systime;//订单生产时间
	private Integer amount;//数量
	private Integer pay;//付费状态
//	@ManyToOne//多对一
//	@NotFound(action=NotFoundAction.IGNORE)
	private Integer userid;
	private float total;//总价
	@OneToMany//一对多
	@Transient // 不持久化
	private List<User_Orders> user_Orders;//获取订单列表
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status=status;
	}
	public Date getSystime() {
		return systime;
	}
	public void setSystime(Date systime) {
		this.systime=systime;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount=amount;
	}
	public Integer getPay() {
		return pay;
	}
	public void setPay(Integer pay) {
		this.pay=pay;
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
		this.total=(float)Math.round(total*100)/100;
	}
	public List<User_Orders> getUser_Orders(){
		return user_Orders;
	}
	public void setUser_Order(List<User_Orders> user_Orders) {
		this.user_Orders=user_Orders;
	}
}
