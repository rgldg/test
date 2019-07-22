package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Product;
import com.example.demo.entity.ShopCart;
import com.example.demo.entity.User;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/*")
public class UserProductController {

	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	
	@RequestMapping("touproductshow")
	public String productShow(HttpSession session) {
		List<Product> productList=productService.findAll();
		session.setAttribute("productList", productList);
		return "uproductshow";
	}
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request,Integer id,Integer uid) {
		Product product=productService.findById(id);
		Integer productid=product.getId();
		float price=product.getPrice();
		User user=userService.findById(uid);
		Integer userid=user.getId();
		ShopCart shopCart=new ShopCart();
		shopCart.setProduct(productid);
		shopCart.setUser(userid);
		shopCart.setAmount(1);
		shopCart.setTotal(price);
		productService.saveShop(shopCart);
		return "redirect:/touproductshow";
	}
	@RequestMapping("toshopcart")
	public String toshopcart(HttpSession session,Integer uid) {
		List<ShopCart> shopList=productService.findByuserid(uid);
		session.setAttribute("shopList",shopList);
		return "shopcart";
	}
}
