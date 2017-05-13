package com.simrin.dao;

import java.util.List;

import com.simrin.model.Product;



public interface ProductDao {
	int saveorupdate(Product product);
	List<Product>getAllProduct();
	Product getProductBy(int productid);
	int deleteProductintById(int productid);


}
