package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="admin")//管理员表
public class Admin {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String username;
		private String password;
		private String permission;//权限
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id=id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username=username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password=password;
		}
		public String getPermission() {
			return permission;
		}
		public void setPermission(String permission) {
			this.permission=permission;
		}
		
}
