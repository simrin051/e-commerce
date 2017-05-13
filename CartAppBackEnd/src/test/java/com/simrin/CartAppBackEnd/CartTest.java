package com.simrin.CartAppBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simrin.dao.CartDao;
import com.simrin.model.Cart;



public class CartTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.simrin.*");
		context.refresh();
		CartDao cartDAO=(CartDao)context.getBean("cartDao");
		Cart cart=(Cart)context.getBean("cart");
		List<Cart> lst=cartDAO.getAllCart();
		for(Cart car:lst){
		System.out.println(car.getCartid()+" "+car.getUserid()+" "+car.getProductid()+" "+car.getProductname()+""+car.getProductprice());
		}
	
	cart.setCartid(5);
	cart.setUserid(90);
	cart.setProductid(87);
	cart.setProductname("sss");
	cart.setProductprice(45);
	cartDAO.saveorupdate(cart);
	
	}

}
