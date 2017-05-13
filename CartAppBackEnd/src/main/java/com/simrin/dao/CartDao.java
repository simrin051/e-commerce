package com.simrin.dao;



import java.util.List;

import com.simrin.model.Cart;



public interface CartDao {
int saveorupdate(Cart cart);
List<Cart>getAllCart();
Cart getCartBy(int cartid);
int deleteCartintById(int cartid);

}
