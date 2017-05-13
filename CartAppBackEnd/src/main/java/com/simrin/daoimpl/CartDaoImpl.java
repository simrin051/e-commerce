package com.simrin.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simrin.dao.CartDao;
import com.simrin.model.Cart;

public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int saveorupdate(Cart cart) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
		return 0;
	}
	@Transactional
	public List<Cart> getAllCart() {
		@SuppressWarnings("unchecked")List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
			
		

	}
	@Transactional
	public Cart getCartBy(int cartid) {
		System.out.println("asfaaaadada "+cartid);
		String hql = "from Users where u= " + cartid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> listCart = (List<Cart>) query.list();
		if (listCart!= null && !listCart.isEmpty()) {
			return listCart.get(0);
		}
		return null;
	}
	@Transactional
	public int deleteCartintById(int cartid) {
		Cart cartToDelete = new Cart();
		cartToDelete.setUserid(cartid);
		sessionFactory.getCurrentSession().delete(cartToDelete);
		return 0;
		
		
	}

}
