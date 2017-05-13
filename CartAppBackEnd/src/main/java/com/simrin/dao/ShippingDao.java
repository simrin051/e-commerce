package com.simrin.dao;



import java.util.List;

import com.simrin.model.Shipping;





public interface ShippingDao {
	int saveorupdate(Shipping shipping);
	List<Shipping>getAllShipping();
	Shipping getShippingBy(int shippingid);
	int deleteShippingintById(int shippingid);


}
