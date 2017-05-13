package com.simrin.CartAppBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simrin.dao.ProductDao;

import com.simrin.model.Product;


public class ProductTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.simrin.*");
		context.refresh();
		ProductDao productDAO=(ProductDao)context.getBean("productDao");
			
		Product product=(Product)context.getBean("product");
//		List<Product> lst=productDAO.getAllProduct();
//		for(Product prod:lst){
//		System.out.println(prod.getProductid()+" "+prod.getProductname()+" "+prod.getPrice()+" "+prod.getCategory());
//		}
	
		product.setProductid(5);
		product.setProductname("ji");
		product.setPrice(9200.92);
		product.setCategory("cosemetics");
		productDAO.saveorupdate(product);

//		productDAO.deleteProductintById(5);
	
	}
}
